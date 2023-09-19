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

app.use('/', indexRouter);
app.use('/users', usersRouter);

// socket.io 모듈 불러오기
var io = require("socket.io")();
io.listen(5674); //웹소켓서비스 포트번호 지정
// 웹소켓서버 시작 -자동으로 생김->
// http://주소:포트/socket.io/socket.io.js

io.sockets.on("connection",function(socket){
	socket.on("clientMsg",function(m){
		io.sockets.emit("serverMsg",m);
	});
});

// io.sockets - 연결된 모든 소켓들
// socket- 소켓하나

// emit("제목",내용) - 보내기
// on("제목", 콜백함수) - 받으면




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
