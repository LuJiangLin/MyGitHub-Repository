/* 分页工具  */
(function($){
    var ms = {
    	initFillHtml:function(obj,args){
            return (function(){
                ms.fillHtml(obj,args);
            })();
        },
        initBindEvent:function(obj,args){
        	return (function(){
        		ms.bindEvent(obj,args);
        	})();
        },
        //填充html
        fillHtml:function(obj,args){
            return (function(){
                obj.empty();
                //上一页
                //obj.append('<span style="color:#666;margin-right:20px;"> 每页显示<input type="text" id="recordsSet" style="width:34px;height:20px;text-align:center;margin:0 6px;">个结果 <input type="button" class="setPageBars" style="width:48px;height:26px;margin:0 4px;" value="确定"/></span>');
                if(args.current > 1){
                    obj.append('<input type="button" value="首页"  class="firstPage shortcutBtn"/><input type="button" value="上一页"  class="prevPage shortcutBtn"/>');
                }else{
                    obj.remove('.prevPage');
                    obj.append('<input type="button" value="首页"  class="disabled firstPage shortcutBtn"/><input type="button" value="上一页"  class="disabled prevPage shortcutBtn"/>');
                }
                //中间页码
                var start = args.current-3,end = args.current+3;
                if(start<1){
                	end-=(start-1);
                }else if(end>args.pageCount){
                	start-=(end-args.pageCount);
                }
                for (;start <= end; start++) {
                    if(start <= args.pageCount && start >= 1){
                        if(start != args.current){
                            obj.append('<a href="javascript:;" class="tcdNumber">'+ start +'</a>');
                        }else{
                            obj.append('<span class="current">'+ start +'</span>');
                        }
                    }
                }
                //大于7页 则添加省略号
                if(args.pageCount>7&&args.current<args.pageCount-3){
                	obj.append('<span style="color:#333">...</span>');
                }
                //下一页
                if(args.current < args.pageCount){
                    obj.append('<input type="button" value="下一页"  class=" nextPage shortcutBtn"/><input type="button" value="尾页"  class="lastPage shortcutBtn"/>');
                }else{
                    obj.remove('.nextPage');
                    obj.append('<input type="button" value="下一页"  class="nextPage shortcutBtn disabled"/><input type="button" value="尾页"  class=" disabled lastPage shortcutBtn"/>');
                }
              //大于7页 则添加跳转功能
               /* if(args.pageCount>7){
                	obj.append('<div class="jumpPageBox">共<em class="pageTotal">'+args.pageCount+'</em>页   跳转至<input type="text" class="jumpTo"/>页<input class="confirmJumpPage" type="button" value="跳转"></div>');
                }*/
                if(args.pageCount>7){
                	obj.append('<div class="jumpPageBox">共<em class="pageTotal">'+args.pageCount+'</em>页  </div>');
                }
                //如果没有总页数值为空 则隐藏分页
                if(!args.pageCount||args.pageCount=="0"){
                	obj.empty();
                }
            })();
        },
        //绑定事件
        bindEvent:function(obj,args){
            return (function(){
                obj.on("click","a.tcdNumber",function(){
                    var current = parseInt($(this).text());
                    ms.fillHtml(obj,{"current":current,"pageCount":args.pageCount});
                    if(typeof(args.backFn)=="function"){
                        args.backFn(current);
                    }
                });
                //上一页
                obj.on("click",".prevPage",function(){
                	if(!$(this).hasClass("disabled")){
                		var current = parseInt(obj.children("span.current").text());
                        ms.fillHtml(obj,{"current":current-1,"pageCount":args.pageCount});
                        if(typeof(args.backFn)=="function"){
                            args.backFn(current-1);
                        }
                	}
                });
                //下一页
                obj.on("click",".nextPage",function(){
                	if(!$(this).hasClass("disabled")){
	                    var current = parseInt(obj.children("span.current").text());
	                    ms.fillHtml(obj,{"current":current+1,"pageCount":args.pageCount});
	                    if(typeof(args.backFn)=="function"){
	                        args.backFn(current+1);
	                    }
                	}
                });
                //首页
                obj.on("click",".firstPage",function(){
                	if(!$(this).hasClass("disabled")){
	            		ms.fillHtml(obj,{"current":1,"pageCount":args.pageCount});
	            		if(typeof(args.backFn)=="function"){
	            			args.backFn(1);
	            		}
                	}
                });
                //尾页
                obj.on("click",".lastPage",function(){
                	if(!$(this).hasClass("disabled")){
                		var current = parseInt($(".sumpage").text()||$(".sumpage").val());
                		ms.fillHtml(obj,{"current":current,"pageCount":args.pageCount});
                		if(typeof(args.backFn)=="function"){
                			args.backFn(current);
                		}
                	}
                });
                //输入跳转页数
                obj.on("blur",".jumpTo",function(){
                	var pageTotal=parseInt($(".sumpage").text()||$(".sumpage").val());
                	var thsVal=parseInt($(this).val());
            		if(!validateInteger(this)){
            			$(this).val("1")
            		}else if(thsVal>pageTotal){
            			$(this).val(pageTotal)
            		}
                });
                //跳转
                obj.on("click",".confirmJumpPage",function(){
            		var jumpTo = parseInt($(".jumpTo").val());
            		if(!jumpTo){
            			return false;
            		}else{
            			ms.fillHtml(obj,{"current":jumpTo,"pageCount":args.pageCount});
                		if(typeof(args.backFn)=="function"){
                			args.backFn(jumpTo);
                		}
            		}
                });
            })();
        }
    }
    $.fn.createPage = function(options){
        var args = $.extend({
            pageCount : 10,
            current : 1,
            backFn : function(){}
        },options);
        ms.initFillHtml(this,args);
        ms.initBindEvent(this,args);
    }
    $.fn.ajaxcreatePage = function(options){
    	var args = $.extend({
    		pageCount : 10,
    		current : 1,
    	},options);
    	ms.initFillHtml(this,args);
    }
})(jQuery);
