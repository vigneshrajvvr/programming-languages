import addTwo from './addTwo';
import {addThree} from './addTwo';

export default addTwo;

console.log(addTwo(1, 2));
console.log(addThree(1,2,3));

// Importing modules
// 2 ways for default modules
// Adding export default addTwo
// or import addTwo from './addTwo';

// Named imports
// import {addThree} from './addThree';