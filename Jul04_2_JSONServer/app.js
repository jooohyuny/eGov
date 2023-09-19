var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');

var indexRouter = require('./routes/index');
var usersRouter = require('./routes/users');

var app = express();

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.listen(80);

app.get("/",function(req,res){
	res.send("hi");
});
app.get("/snack.get", function(req,res){
	var mjs = require("mongojs"); //mongojs모듈 불러오기
	// "서버주소/DB명",["테이블명","테이블명",....]
	var db = mjs("195.168.9.85/xe",["jul04_snack"]);
	
	// Node.js	: JavaScript
	// NoSQL 	: JavaScript
	
	// MongoDB명령어 그대로 + 결과가 나오면 호출될 콜백함수
	db.jul04_snack.find(function(err,result){
		res.setHeader("Access-Control-Allow-Origin","*");
		res.send(result);
	});
	

});


// catch 404 and forward to error handler
app.use(function(req, res, next) {
  next(createError(404));
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

module.exports = app;
