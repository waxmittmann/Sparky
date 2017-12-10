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


//var data = JSON.parse("../out/jobSatisfactionByIdeResult.json")

console.log("HIe")

console.log(__WEBPACK_IMPORTED_MODULE_0__out_jobSatisfactionByIdeResult_json___default.a)

var app = new Vue({
  el: '#app',
  data: {
    message: 'Hello Vue!'
  }
})

var chart = c3.generate({
    bindto: '#chart',
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
    }
);

console.log(['x'].concat(Array.from(__WEBPACK_IMPORTED_MODULE_0__out_jobSatisfactionByIdeResult_json___default.a, d => d.ide)))

var jobSatisfactionByIde = c3.generate(
{
    bindto: '#jobSatisfactionByIde',
    data: {
        //labels: true,
        x: 'x',
        columns: [
            ['x'].concat(Array.from(__WEBPACK_IMPORTED_MODULE_0__out_jobSatisfactionByIdeResult_json___default.a, d => d.ide)),
            ['IDE'].concat(Array.from(__WEBPACK_IMPORTED_MODULE_0__out_jobSatisfactionByIdeResult_json___default.a, d => d.jobSatisfactionMean)),
            // ['data2', 130, 100, 140, 200, 150, 50]
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


// setTimeout(function () {
//     chart.load({
//         columns: [
//             ['data3', 130, -150, 200, 300, -200, 100]
//         ]
//     });
// }, 1000);


/***/ }),
/* 1 */
/***/ (function(module, exports) {

module.exports = [{"ide":"TextMate","jobSatisfactionMean":6.222222222222222,"jobSatisfactionStdDev":2.3588350014578308,"jobSatisfactionTotal":27},{"ide":"Notepad++","jobSatisfactionMean":6.305177111716621,"jobSatisfactionStdDev":2.369554596611772,"jobSatisfactionTotal":734},{"ide":"Atom","jobSatisfactionMean":6.327137546468402,"jobSatisfactionStdDev":2.422848249779201,"jobSatisfactionTotal":269},{"ide":"Eclipse","jobSatisfactionMean":6.342465753424658,"jobSatisfactionStdDev":2.4095677316142488,"jobSatisfactionTotal":511},{"ide":"PyCharm","jobSatisfactionMean":6.397058823529412,"jobSatisfactionStdDev":2.5011979700541604,"jobSatisfactionTotal":136},{"ide":"Sublime Text","jobSatisfactionMean":6.408759124087592,"jobSatisfactionStdDev":2.378467527841239,"jobSatisfactionTotal":548},{"ide":"Vim","jobSatisfactionMean":6.411764705882353,"jobSatisfactionStdDev":2.4074125544658758,"jobSatisfactionTotal":408},{"ide":"Visual Studio","jobSatisfactionMean":6.433389544688027,"jobSatisfactionStdDev":2.404113481820602,"jobSatisfactionTotal":593},{"ide":"Android Studio","jobSatisfactionMean":6.447300771208226,"jobSatisfactionStdDev":2.4028385628883875,"jobSatisfactionTotal":389},{"ide":"NetBeans","jobSatisfactionMean":6.467532467532467,"jobSatisfactionStdDev":2.1724625313289603,"jobSatisfactionTotal":231},{"ide":"NA","jobSatisfactionMean":6.5016891891891895,"jobSatisfactionStdDev":2.411930865531349,"jobSatisfactionTotal":1184},{"ide":"PHPStorm","jobSatisfactionMean":6.511494252873563,"jobSatisfactionStdDev":2.507188522248366,"jobSatisfactionTotal":174},{"ide":"RStudio","jobSatisfactionMean":6.511627906976744,"jobSatisfactionStdDev":2.5669334402788286,"jobSatisfactionTotal":43},{"ide":"Emacs","jobSatisfactionMean":6.532467532467533,"jobSatisfactionStdDev":2.7269822128249332,"jobSatisfactionTotal":77},{"ide":"RubyMine","jobSatisfactionMean":6.576923076923077,"jobSatisfactionStdDev":2.2657992307012007,"jobSatisfactionTotal":26},{"ide":"IPython / Jupyter","jobSatisfactionMean":6.581081081081081,"jobSatisfactionStdDev":2.5696156994093244,"jobSatisfactionTotal":74},{"ide":"IntelliJ","jobSatisfactionMean":6.645645645645645,"jobSatisfactionStdDev":2.31039178481832,"jobSatisfactionTotal":333},{"ide":"Visual Studio Code","jobSatisfactionMean":6.743150684931507,"jobSatisfactionStdDev":2.2534710159724063,"jobSatisfactionTotal":292},{"ide":"Xcode","jobSatisfactionMean":6.752941176470588,"jobSatisfactionStdDev":2.2995028140416762,"jobSatisfactionTotal":170}]

/***/ })
/******/ ]);