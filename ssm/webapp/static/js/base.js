// 项目基本路径
var origin = window.location.origin;
var pathName = window.location.pathname;
var projectName = pathName.substring(0,pathName.indexOf("/",1));
var basePath = origin + projectName;