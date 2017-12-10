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
                min: 6
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
                min: 5.8
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


/***/ }),
/* 1 */
/***/ (function(module, exports) {

module.exports = [{"ide":"TextMate","jobSatisfactionMean":6.222222222222222,"jobSatisfactionStdDev":2.3588350014578308,"jobSatisfactionTotal":27},{"ide":"Notepad++","jobSatisfactionMean":6.305177111716621,"jobSatisfactionStdDev":2.369554596611772,"jobSatisfactionTotal":734},{"ide":"Atom","jobSatisfactionMean":6.327137546468402,"jobSatisfactionStdDev":2.422848249779201,"jobSatisfactionTotal":269},{"ide":"Eclipse","jobSatisfactionMean":6.342465753424658,"jobSatisfactionStdDev":2.4095677316142488,"jobSatisfactionTotal":511},{"ide":"PyCharm","jobSatisfactionMean":6.397058823529412,"jobSatisfactionStdDev":2.5011979700541604,"jobSatisfactionTotal":136},{"ide":"Sublime Text","jobSatisfactionMean":6.408759124087592,"jobSatisfactionStdDev":2.378467527841239,"jobSatisfactionTotal":548},{"ide":"Vim","jobSatisfactionMean":6.411764705882353,"jobSatisfactionStdDev":2.4074125544658758,"jobSatisfactionTotal":408},{"ide":"Visual Studio","jobSatisfactionMean":6.433389544688027,"jobSatisfactionStdDev":2.404113481820602,"jobSatisfactionTotal":593},{"ide":"Android Studio","jobSatisfactionMean":6.447300771208226,"jobSatisfactionStdDev":2.4028385628883875,"jobSatisfactionTotal":389},{"ide":"NetBeans","jobSatisfactionMean":6.467532467532467,"jobSatisfactionStdDev":2.1724625313289603,"jobSatisfactionTotal":231},{"ide":"NA","jobSatisfactionMean":6.5016891891891895,"jobSatisfactionStdDev":2.411930865531349,"jobSatisfactionTotal":1184},{"ide":"PHPStorm","jobSatisfactionMean":6.511494252873563,"jobSatisfactionStdDev":2.507188522248366,"jobSatisfactionTotal":174},{"ide":"RStudio","jobSatisfactionMean":6.511627906976744,"jobSatisfactionStdDev":2.5669334402788286,"jobSatisfactionTotal":43},{"ide":"Emacs","jobSatisfactionMean":6.532467532467533,"jobSatisfactionStdDev":2.7269822128249332,"jobSatisfactionTotal":77},{"ide":"RubyMine","jobSatisfactionMean":6.576923076923077,"jobSatisfactionStdDev":2.2657992307012007,"jobSatisfactionTotal":26},{"ide":"IPython / Jupyter","jobSatisfactionMean":6.581081081081081,"jobSatisfactionStdDev":2.5696156994093244,"jobSatisfactionTotal":74},{"ide":"IntelliJ","jobSatisfactionMean":6.645645645645645,"jobSatisfactionStdDev":2.31039178481832,"jobSatisfactionTotal":333},{"ide":"Visual Studio Code","jobSatisfactionMean":6.743150684931507,"jobSatisfactionStdDev":2.2534710159724063,"jobSatisfactionTotal":292},{"ide":"Xcode","jobSatisfactionMean":6.752941176470588,"jobSatisfactionStdDev":2.2995028140416762,"jobSatisfactionTotal":170}]

/***/ }),
/* 2 */
/***/ (function(module, exports) {

module.exports = [{"hoursPerWeek":"12","jobSatisfactionMean":4.153846153846154,"jobSatisfactionStdDev":2.409915415049314,"jobSatisfactionTotal":13},{"hoursPerWeek":"9","jobSatisfactionMean":4.833333333333333,"jobSatisfactionStdDev":1.7494587907710375,"jobSatisfactionTotal":12},{"hoursPerWeek":"4","jobSatisfactionMean":5.329545454545454,"jobSatisfactionStdDev":2.3129897600495433,"jobSatisfactionTotal":88},{"hoursPerWeek":"20","jobSatisfactionMean":5.4,"jobSatisfactionStdDev":3.1187041843486347,"jobSatisfactionTotal":20},{"hoursPerWeek":"8","jobSatisfactionMean":5.620689655172414,"jobSatisfactionStdDev":2.717848323102149,"jobSatisfactionTotal":29},{"hoursPerWeek":"10","jobSatisfactionMean":5.673076923076923,"jobSatisfactionStdDev":2.3822970777205428,"jobSatisfactionTotal":52},{"hoursPerWeek":"2","jobSatisfactionMean":5.721311475409836,"jobSatisfactionStdDev":2.2638910455643115,"jobSatisfactionTotal":183},{"hoursPerWeek":"3","jobSatisfactionMean":5.820224719101123,"jobSatisfactionStdDev":2.635258300919255,"jobSatisfactionTotal":89},{"hoursPerWeek":"7","jobSatisfactionMean":5.896551724137931,"jobSatisfactionStdDev":1.819435304589368,"jobSatisfactionTotal":29},{"hoursPerWeek":"6","jobSatisfactionMean":6.235294117647059,"jobSatisfactionStdDev":2.2300811716360376,"jobSatisfactionTotal":34},{"hoursPerWeek":"1","jobSatisfactionMean":6.359872611464968,"jobSatisfactionStdDev":2.1673841323887513,"jobSatisfactionTotal":314},{"hoursPerWeek":"40","jobSatisfactionMean":6.428571428571429,"jobSatisfactionStdDev":2.433531985012304,"jobSatisfactionTotal":56},{"hoursPerWeek":"5","jobSatisfactionMean":6.580645161290323,"jobSatisfactionStdDev":1.98806592806186,"jobSatisfactionTotal":62},{"hoursPerWeek":"0","jobSatisfactionMean":6.7229437229437226,"jobSatisfactionStdDev":2.2556869177109142,"jobSatisfactionTotal":231}]

/***/ }),
/* 3 */
/***/ (function(module, exports) {

module.exports = [{"gender":"Female","jobSatisfactionMean":6.155555555555556,"jobSatisfactionStdDev":2.272045126032132,"jobSatisfactionTotal":135},{"gender":"Male","jobSatisfactionMean":6.54464894342195,"jobSatisfactionStdDev":2.322531181158359,"jobSatisfactionTotal":1467}]

/***/ })
/******/ ]);