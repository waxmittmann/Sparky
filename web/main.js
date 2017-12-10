import data from '../out/jobSatisfactionByIdeResult.json';

//var data = JSON.parse("../out/jobSatisfactionByIdeResult.json")

console.log("HIe")

console.log(data)

var app = new Vue({
  el: '#app',
  data: {
    message: 'Hello Vue!'
  }
})

var chart = c3.generate({
data: {
    columns: [
        ['Peters per Pan', 30, 200, 100, 400, 150, 250],
        // ['data2', 130, 100, 140, 200, 150, 50]
    ],
    type: 'bar'
},
bar: {
    width: {
        // ratio: 0.5 // this makes bar width 50% of length between ticks
        ratio: 0.85 // this makes bar width 50% of length between ticks
    }
        // or
        //width: 100 // this makes bar width 100px
    }
});

// setTimeout(function () {
//     chart.load({
//         columns: [
//             ['data3', 130, -150, 200, 300, -200, 100]
//         ]
//     });
// }, 1000);
