import ideData from '../out/jobSatisfactionByIdeResult.json';
import hoursData from '../out/jobSatisfactionByHoursPerWeek.json';
import genderData from '../out/jobSatisfactionByGender.json';
import developerTypeData from '../out/jobSatisfactionByDeveloperTypeJson.json';
import overpaidData from '../out/overpaid.json';

import developerTypeMenData from '../out/developerTypeByGenderMale.json';
import developerTypeWomenData from '../out/developerTypeByGenderFemale.json';

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


var jobSatisfactionByDeveloperType = c3.generate(
    {
        bindto: '#jobSatisfactionByDeveloperType',
        data: {
            x: 'x',
            columns: [
                ['x'].concat(Array.from(developerTypeData, d => d.developerType)),
                ['DeveloperType'].concat(Array.from(developerTypeData, d => d.jobSatisfactionMean)),
            ],
            groups: [
                ['developerType']
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

var overpaid = c3.generate({
    bindto: "#overpaid",
    data: {
        columns: overpaidData.map(x => [x.overpaid, x.count]),
        type : 'pie',
        onclick: function (d, i) { console.log("onclick", d, i); },
        onmouseover: function (d, i) { console.log("onmouseover", d, i); },
        onmouseout: function (d, i) { console.log("onmouseout", d, i); }
    }
});


var developerTypeMen = c3.generate({
    bindto: "#developerTypeMen",
    data: {
        columns: developerTypeMenData.map(x => [x.developerType, x.count]),
        type : 'pie',
        onclick: function (d, i) { console.log("onclick", d, i); },
        onmouseover: function (d, i) { console.log("onmouseover", d, i); },
        onmouseout: function (d, i) { console.log("onmouseout", d, i); }
    }
});

var developerTypeWomen = c3.generate({
    bindto: "#developerTypeWomen",
    data: {
        columns: developerTypeWomenData.map(x => [x.developerType, x.count]),
        type : 'pie',
        onclick: function (d, i) { console.log("onclick", d, i); },
        onmouseover: function (d, i) { console.log("onmouseover", d, i); },
        onmouseout: function (d, i) { console.log("onmouseout", d, i); }
    }
});