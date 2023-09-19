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

app.listen(8888);
app.get("/",function(req,res){
	res.send("Aaa");
});

app.get("/memo.reg", function(req,res){
	var db = require("mongojs")("195.168.9.85/xe",["jul05_memo1"]) 
	var txt = req.query.txt;
	var m = {m_txt:txt, m_date: new Date()};
	
	db.jul05_memo1.insertOne(m, function(err,result){
		res.setHeader("Access-Control-Allow-Origin","*");
		res.send(result);
	})
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
