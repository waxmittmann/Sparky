import ideData from '../out/jobSatisfactionByIdeResult.json';
import hoursData from '../out/jobSatisfactionByHoursPerWeek.json';
import genderData from '../out/jobSatisfactionByGender.json';


var app = new Vue({
  el: '#app',
  data: {
    message: 'Hello Vue!'
  }
})

var jobSatisfactionByIde = c3.generate(
    {
        bindto: '#jobSatisfactionByIde',
        data: {
            x: 'x',
            columns: [
                ['x'].concat(Array.from(ideData, d => d.ide)),
                ['IDE'].concat(Array.from(ideData, d => d.jobSatisfactionMean)),
            ],
            groups: [
                ['IDE']
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
        },
         axis: {
            x: {
                type: 'category' // this needed to load string x value
            },
            y: {
                min: 5.5
            }
        }
    }
);

var jobSatisfactionByGender = c3.generate(
    {
        bindto: '#jobSatisfactionByGender',
        data: {
            x: 'x',
            columns: [
                ['x'].concat(Array.from(genderData, d => d.gender)),
                ['Gender'].concat(Array.from(genderData, d => d.jobSatisfactionMean)),
            ],
            groups: [
                ['Gender']
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
        },
         axis: {
            x: {
                type: 'category' // this needed to load string x value
            },
            y: {
                min: 5
            }
        }
    }
);

var jobSatisfactionByHours = c3.generate(
    {
        bindto: '#jobSatisfactionByHoursPerWeek',
        data: {
            x: 'x',
            columns: [
                ['x'].concat(Array.from(hoursData, d => d.hoursPerWeek)),
                ['HoursPerWeek'].concat(Array.from(hoursData, d => d.jobSatisfactionMean)),
            ],
            groups: [
                ['hoursPerWeek']
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
        },
         axis: {
            x: {
                type: 'category' // this needed to load string x value
            },
            y: {
                min: 4
            }
        }
    }
);
