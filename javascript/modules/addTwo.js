function addTwo(a, b){
    console.log(a + b);
}

function addThree(a, b, c) {
    console.log(a + b + c);
}

export default addTwo;
export {addThree};

// Default export
// There are ways to do default export, one is export default addTwo(a, b)
// or at the end fo the file add the export default addTwo

// Named export
// Similar to default export there are 2 ways
// Either add thee export function addTwo(a, b)
// or at the end export {addTwo, addThree}