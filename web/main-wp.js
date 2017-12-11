/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, {
/******/ 				configurable: false,
/******/ 				enumerable: true,
/******/ 				get: getter
/******/ 			});
/******/ 		}
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = 0);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__out_jobSatisfactionByIdeResult_json__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__out_jobSatisfactionByIdeResult_json___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0__out_jobSatisfactionByIdeResult_json__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__out_jobSatisfactionByHoursPerWeek_json__ = __webpack_require__(2);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__out_jobSatisfactionByHoursPerWeek_json___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1__out_jobSatisfactionByHoursPerWeek_json__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__out_jobSatisfactionByGender_json__ = __webpack_require__(3);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__out_jobSatisfactionByGender_json___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2__out_jobSatisfactionByGender_json__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__out_jobSatisfactionByDeveloperTypeJson_json__ = __webpack_require__(4);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__out_jobSatisfactionByDeveloperTypeJson_json___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_3__out_jobSatisfactionByDeveloperTypeJson_json__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__out_overpaid_json__ = __webpack_require__(5);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__out_overpaid_json___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_4__out_overpaid_json__);






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
                ['x'].concat(Array.from(__WEBPACK_IMPORTED_MODULE_0__out_jobSatisfactionByIdeResult_json___default.a, d => d.ide)),
                ['IDE'].concat(Array.from(__WEBPACK_IMPORTED_MODULE_0__out_jobSatisfactionByIdeResult_json___default.a, d => d.jobSatisfactionMean)),
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
                ['x'].concat(Array.from(__WEBPACK_IMPORTED_MODULE_2__out_jobSatisfactionByGender_json___default.a, d => d.gender)),
                ['Gender'].concat(Array.from(__WEBPACK_IMPORTED_MODULE_2__out_jobSatisfactionByGender_json___default.a, d => d.jobSatisfactionMean)),
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
                ['x'].concat(Array.from(__WEBPACK_IMPORTED_MODULE_1__out_jobSatisfactionByHoursPerWeek_json___default.a, d => d.hoursPerWeek)),
                ['HoursPerWeek'].concat(Array.from(__WEBPACK_IMPORTED_MODULE_1__out_jobSatisfactionByHoursPerWeek_json___default.a, d => d.jobSatisfactionMean)),
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
                ['x'].concat(Array.from(__WEBPACK_IMPORTED_MODULE_3__out_jobSatisfactionByDeveloperTypeJson_json___default.a, d => d.developerType)),
                ['DeveloperType'].concat(Array.from(__WEBPACK_IMPORTED_MODULE_3__out_jobSatisfactionByDeveloperTypeJson_json___default.a, d => d.jobSatisfactionMean)),
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
        columns: __WEBPACK_IMPORTED_MODULE_4__out_overpaid_json___default.a.map(x => [x.overpaid, x.count]),
        type : 'pie',
        onclick: function (d, i) { console.log("onclick", d, i); },
        onmouseover: function (d, i) { console.log("onmouseover", d, i); },
        onmouseout: function (d, i) { console.log("onmouseout", d, i); }
    }
});

/***/ }),
/* 1 */
/***/ (function(module, exports) {

module.exports = [{"ide":"Vim","jobSatisfactionMean":5.657407407407407,"jobSatisfactionStdDev":2.427217900307425,"jobSatisfactionTotal":216},{"ide":"PyCharm","jobSatisfactionMean":5.705882352941177,"jobSatisfactionStdDev":2.5040792005583627,"jobSatisfactionTotal":68},{"ide":"PHPStorm","jobSatisfactionMean":5.827586206896552,"jobSatisfactionStdDev":2.3536557243243426,"jobSatisfactionTotal":87},{"ide":"Atom","jobSatisfactionMean":5.89375,"jobSatisfactionStdDev":2.3407703806317195,"jobSatisfactionTotal":160},{"ide":"RStudio","jobSatisfactionMean":5.916666666666667,"jobSatisfactionStdDev":3.063340981839027,"jobSatisfactionTotal":24},{"ide":"Notepad++","jobSatisfactionMean":5.945812807881773,"jobSatisfactionStdDev":2.334289688547196,"jobSatisfactionTotal":406},{"ide":"Eclipse","jobSatisfactionMean":5.9825174825174825,"jobSatisfactionStdDev":2.3774618541870116,"jobSatisfactionTotal":286},{"ide":"Emacs","jobSatisfactionMean":6,"jobSatisfactionStdDev":2.5495097567963922,"jobSatisfactionTotal":45},{"ide":"Sublime Text","jobSatisfactionMean":6.003205128205129,"jobSatisfactionStdDev":2.2759731990520446,"jobSatisfactionTotal":312},{"ide":"IPython / Jupyter","jobSatisfactionMean":6.071428571428571,"jobSatisfactionStdDev":2.69952893038638,"jobSatisfactionTotal":42},{"ide":"Visual Studio","jobSatisfactionMean":6.096774193548387,"jobSatisfactionStdDev":2.4116067601652875,"jobSatisfactionTotal":310},{"ide":"Xcode","jobSatisfactionMean":6.153061224489796,"jobSatisfactionStdDev":2.2399928240695375,"jobSatisfactionTotal":98},{"ide":"Android Studio","jobSatisfactionMean":6.168949771689498,"jobSatisfactionStdDev":2.2895342846493496,"jobSatisfactionTotal":219},{"ide":"NetBeans","jobSatisfactionMean":6.1838235294117645,"jobSatisfactionStdDev":1.9896108157770651,"jobSatisfactionTotal":136},{"ide":"NA","jobSatisfactionMean":6.1902017291066285,"jobSatisfactionStdDev":2.4679721180298464,"jobSatisfactionTotal":347},{"ide":"IntelliJ","jobSatisfactionMean":6.203592814371257,"jobSatisfactionStdDev":2.2748995003770003,"jobSatisfactionTotal":167},{"ide":"Visual Studio Code","jobSatisfactionMean":6.3202614379084965,"jobSatisfactionStdDev":2.3273363891029275,"jobSatisfactionTotal":153}]

/***/ }),
/* 2 */
/***/ (function(module, exports) {

module.exports = [{"hoursPerWeek":0,"jobSatisfactionMean":6.7229437229437226,"jobSatisfactionStdDev":2.2556869177109142,"jobSatisfactionTotal":231},{"hoursPerWeek":1,"jobSatisfactionMean":6.359872611464968,"jobSatisfactionStdDev":2.1673841323887513,"jobSatisfactionTotal":314},{"hoursPerWeek":2,"jobSatisfactionMean":5.721311475409836,"jobSatisfactionStdDev":2.2638910455643115,"jobSatisfactionTotal":183},{"hoursPerWeek":3,"jobSatisfactionMean":5.820224719101123,"jobSatisfactionStdDev":2.635258300919255,"jobSatisfactionTotal":89},{"hoursPerWeek":4,"jobSatisfactionMean":5.329545454545454,"jobSatisfactionStdDev":2.3129897600495433,"jobSatisfactionTotal":88},{"hoursPerWeek":5,"jobSatisfactionMean":6.580645161290323,"jobSatisfactionStdDev":1.98806592806186,"jobSatisfactionTotal":62},{"hoursPerWeek":6,"jobSatisfactionMean":6.235294117647059,"jobSatisfactionStdDev":2.2300811716360376,"jobSatisfactionTotal":34},{"hoursPerWeek":7,"jobSatisfactionMean":5.896551724137931,"jobSatisfactionStdDev":1.819435304589368,"jobSatisfactionTotal":29},{"hoursPerWeek":8,"jobSatisfactionMean":5.620689655172414,"jobSatisfactionStdDev":2.717848323102149,"jobSatisfactionTotal":29},{"hoursPerWeek":9,"jobSatisfactionMean":4.833333333333333,"jobSatisfactionStdDev":1.7494587907710375,"jobSatisfactionTotal":12},{"hoursPerWeek":10,"jobSatisfactionMean":5.673076923076923,"jobSatisfactionStdDev":2.3822970777205428,"jobSatisfactionTotal":52},{"hoursPerWeek":12,"jobSatisfactionMean":4.153846153846154,"jobSatisfactionStdDev":2.409915415049314,"jobSatisfactionTotal":13},{"hoursPerWeek":20,"jobSatisfactionMean":5.4,"jobSatisfactionStdDev":3.1187041843486347,"jobSatisfactionTotal":20},{"hoursPerWeek":40,"jobSatisfactionMean":6.428571428571429,"jobSatisfactionStdDev":2.433531985012304,"jobSatisfactionTotal":56}]

/***/ }),
/* 3 */
/***/ (function(module, exports) {

module.exports = [{"gender":"Female","jobSatisfactionMean":5.602941176470588,"jobSatisfactionStdDev":2.0957647831612434,"jobSatisfactionTotal":68},{"gender":"Male","jobSatisfactionMean":6.136653895274585,"jobSatisfactionStdDev":2.311535077792237,"jobSatisfactionTotal":783}]

/***/ }),
/* 4 */
/***/ (function(module, exports) {

module.exports = [{"developerType":"NA","jobSatisfactionMean":5.859813084112149,"jobSatisfactionStdDev":2.6429056357804774,"jobSatisfactionTotal":214},{"developerType":"Machine learning specialist","jobSatisfactionMean":5.888888888888889,"jobSatisfactionStdDev":3.021615251841096,"jobSatisfactionTotal":36},{"developerType":"Quality assurance engineer","jobSatisfactionMean":5.955555555555556,"jobSatisfactionStdDev":2.74653132941067,"jobSatisfactionTotal":45},{"developerType":"Systems administrator","jobSatisfactionMean":6.121212121212121,"jobSatisfactionStdDev":2.3916211190308627,"jobSatisfactionTotal":99},{"developerType":"DevOps specialist","jobSatisfactionMean":6.127906976744186,"jobSatisfactionStdDev":2.738812587827957,"jobSatisfactionTotal":86},{"developerType":"Web developer","jobSatisfactionMean":6.127937336814622,"jobSatisfactionStdDev":2.302446025565716,"jobSatisfactionTotal":766},{"developerType":"Database administrator","jobSatisfactionMean":6.128834355828221,"jobSatisfactionStdDev":2.5071434713579683,"jobSatisfactionTotal":163},{"developerType":"Data scientist","jobSatisfactionMean":6.158536585365853,"jobSatisfactionStdDev":2.8217388570981075,"jobSatisfactionTotal":82},{"developerType":"Developer with a statistics or mathematics background","jobSatisfactionMean":6.2214285714285715,"jobSatisfactionStdDev":2.411208411161404,"jobSatisfactionTotal":140},{"developerType":"Desktop applications developer","jobSatisfactionMean":6.256505576208179,"jobSatisfactionStdDev":2.3589311986904913,"jobSatisfactionTotal":269},{"developerType":"Other","jobSatisfactionMean":6.357142857142857,"jobSatisfactionStdDev":2.626706287601461,"jobSatisfactionTotal":70},{"developerType":"Mobile developer","jobSatisfactionMean":6.3765822784810124,"jobSatisfactionStdDev":2.215520082165496,"jobSatisfactionTotal":316},{"developerType":"Embedded applications/devices developer","jobSatisfactionMean":6.552941176470588,"jobSatisfactionStdDev":2.447087103908981,"jobSatisfactionTotal":85},{"developerType":"Graphic designer","jobSatisfactionMean":6.60377358490566,"jobSatisfactionStdDev":2.4833261088981,"jobSatisfactionTotal":53},{"developerType":"Graphics programming","jobSatisfactionMean":6.931818181818182,"jobSatisfactionStdDev":2.756790578146036,"jobSatisfactionTotal":44}]

/***/ }),
/* 5 */
/***/ (function(module, exports) {

module.exports = [{"overpaid":"Neither underpaid nor overpaid","count":93},{"overpaid":"Greatly overpaid","count":5},{"overpaid":"Somewhat overpaid","count":21},{"overpaid":"Somewhat underpaid","count":160},{"overpaid":"Greatly underpaid","count":62}]

/***/ })
/******/ ]);