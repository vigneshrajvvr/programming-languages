package com.vvr.concurrency;

public class VolatileDemo {
    public static void main(String[] args) {
        CommonResource commonResource = new CommonResource();
        Thread A = new Thread(() -> {
            System.out.println("Common Resource Flag before modification : " + commonResource.getFlag());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            commonResource.toggleFlag();
            System.out.println("Common Resource Flag after modification : " + commonResource.getFlag());
        });

        Thread B = new Thread(() -> {
           while(!commonResource.getFlag()) {
               try {
                   Thread.sleep(2000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
               System.out.println("Still the flag is not set : " + commonResource.getFlag());
           }

            System.out.println("Flag is updated : " + commonResource.getFlag());
        });

        A.start();
        B.start();
    }
}

class CommonResource {
    private volatile boolean flag;
    // If the flag is not volatile, thread B will not get the updated flag immediately
    // and the loop will execute few more times in it

    public CommonResource() {
    }

    public void toggleFlag() {
        flag = !flag;
    }

    public boolean getFlag() {
        return flag;
    }
}
