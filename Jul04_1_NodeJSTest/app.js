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

// Node.js(Servlet + TomcatWAS)
app.listen(9999);	// WAS포트번호 지정

app.get("/",function(reqq,ress){
	var html = "<html><body>";
	html += "<marquee>HI</marquee>";
	html += "</body></html>";
	ress.send(html);
});
app.get("/paramTest", function(rq,rs){
	// req.getParameter("x");
	var x = rq.query.x;	// req.query.파라메터명
	rs.send(x);
});
app.get("/calculate", function(rq,rs){
	var x = rq.query.x *1;	
	var y = rq.query.y *1;	
	var hab = x + y;
	var cha = x - y;
	var gob = x * y;
	var mok = x / y;
	var html = "<html><body>";
	html += "<h1>"+hab+"</h1>";
	html += "<h1>"+cha+"</h1>";
	html += "<h1>"+gob+"</h1>";
	html += "<h1>"+mok+"</h1>";
	html += "</body></html>";
	rs.send(html);
});

// app.post();

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
