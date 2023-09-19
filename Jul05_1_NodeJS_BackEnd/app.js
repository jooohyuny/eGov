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

app.listen(9999);
app.get("/",function(req,res){
	res.send("Aaa");
});

// snack.reg?n=새우깡&p=5000
// Node.js쪽 한글처리 : 그냥 utf-8쓰면 문제없이 됨
app.get("/snack.reg", function(req,res){
	var db = require("mongojs")("195.168.9.85/xe",["jul05_snack"]);
	// 데이터확보
	var name = req.query.n;
	var price = req.query.p * 1;
	var s = {s_name : name, s_price : price};
	
	db.jul05_snack.insertOne(s, function(err, result){
		res.setHeader("Access-Control-Allow-Origin","*");
		res.send(result);
	});
});

app.get("/snack.get", function(req,res){
	var db = require("mongojs")("195.168.9.85/xe",["jul05_snack"]);
	
	db.jul05_snack.find(function(err, result){
		res.setHeader("Access-Control-Allow-Origin","*");
		res.send(result);
	});
});

app.get("/memo.reg", function(req,res){
	var db = require("mongojs")("195.168.9.85/xe",["jul05_memo"]); 
	var txt = req.query.txt;
	var m = {m_txt:txt, m_date: new Date()};
	
	db.jul05_memo.insertOne(m, function(err,result){
		res.setHeader("Access-Control-Allow-Origin","*");
		res.send(result);
	})
});

app.get("/memo.get", function(req,res){
	var db = require("mongojs")("195.168.9.85/xe",["jul05_memo"]);
	
	db.jul05_memo.find(function(err, result){
		res.setHeader("Access-Control-Allow-Origin","*");
		res.send(result);
	});
});

app.get("/memo.delete", function(req,res){
	var db = require("mongojs")("195.168.9.85/xe",["jul05_memo"]);
	var txt = req.query.txt;
	var m = {m_txt:txt};
	
	db.jul05_memo.remove(m, function(err, result){
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
