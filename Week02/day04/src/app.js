import moment from 'moment';
import './../style.css'
var ball = require('./new.js');

console.log(moment().format('LTS'));
console.log(ball);
console.log('hello cruel world');

var yell = (name) => {
  console.log(name.toUpperCase());
}
yell('simona');
