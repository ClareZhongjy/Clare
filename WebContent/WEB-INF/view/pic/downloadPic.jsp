<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload</title>
<link href="<%=request.getContextPath()%>/static/bootstrap2/css/bootstrap.min.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/static/js/jQuery/jquery-1.9.1.js"></script>
<script src="<%=request.getContextPath()%>/static/bootstrap2/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/bootstrap/js/bootstrap-paginator.min.js"></script>
<script src="<%=request.getContextPath()%>/static/SweetAlert/js/sweet-alert.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/SweetAlert/css/sweet-alert.css">
<script type="text/javascript">
	

</script>
</head>
<body >
<div class="container-fluid">
<div style="border-bottom: solid 1px #ddd;" class="form-group">
	<h3>图片下载</h3>
	</div>
	<div style="width:40%;">
<div id = "queryDiv">
		<input id = "textInput" type="text" placeholder="请输入文件名" >
		<button id = "queryButton" class="btn btn-primary" type="button">查询</button>
	</div>
  <form id="form1">
		<table class="table table-bordered" id = 'tableResult'>
			<caption>图片列表</caption>
			<thead>
				<tr>
					
					<th>上传人</th>
					<th>文件名</th>
					
				</tr>
			</thead>
			<tbody id="tableBody">
			</tbody>
		</table>
		

		<!-- 底部分页按钮 -->
		<div id="bottomTab"></div>
	</form>
 </div>   
</div>

<script type='text/javascript'>    
	    var PAGESIZE = 10;
        var options = {  
            currentPage: 1,  //当前页数
            totalPages: 10,  //总页数，这里只是暂时的，后头会根据查出来的条件进行更改
            size:"normal",  
            alignment:"center",  
            itemTexts: function (type, page, current) {  
                switch (type) {  
                    case "first":  
                        return "第一页";  
                    case "prev":  
                        return "前一页";  
                    case "next":  
                        return "后一页";  
                    case "last":  
                        return "最后页";  
                    case "page":  
                        return  page;  
                }                 
            },  
            onPageClicked: function (e, originalEvent, type, page) {  
            	var fileName = $("#textInput").val(); //取内容
            	buildTable(fileName,page,PAGESIZE);//默认每页最多10条
            }  
        }  

        //获取当前项目的路径
        var urlRootContext = (function () {
            var strPath = window.document.location.pathname;
            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
            return postPath;
        })();
        
       
        //生成表格
        function buildTable(fileName,pageNumber,pageSize) {
        	 var url =  urlRootContext + "/upload/downloadList.do"; //请求的网址
             var reqParams = {'fileName':fileName, 'pageNumber':pageNumber,'pageSize':pageSize};//请求数据
             $(function () {   
             	  $.ajax({
             	        type:"POST",
             	        url:url,
             	        data:reqParams,
             	        async:false,
             	        dataType:"json",
             	        success: function(data){
             	        	console.log(data);
             	            if(data.isError == false) {
             	           // options.totalPages = data.pages;
             	        var newoptions = {  
                        currentPage: 1,  //当前页数
                        totalPages: data.pages==0?1:data.pages,  //总页数
                        size:"normal",  
                        alignment:"center",  
                        itemTexts: function (type, page, current) {  
                        switch (type) {  
                            case "first":  
                            return "第一页";  
                            case "prev":  
                            return "前一页";  
                            case "next":  
                            return "后一页";  
                            case "last":  
                            return "最后页";  
                        case "page":  
                        return  page;  
                }                 
            },  
            onPageClicked: function (e, originalEvent, type, page) {  
            	var userName = $("#textInput").val(); //取内容
            	buildTable(userName,page,PAGESIZE);//默认每页最多10条
            }  
         }             	           
         $('#bottomTab').bootstrapPaginator("setOptions",newoptions); //重新设置总页面数目
         var dataList = data.dataList;
         $("#tableBody").empty();//清空表格内容
         if (dataList.length > 0 ) {
             $(dataList).each(function(){//重新生成
             	    $("#tableBody").append('<tr>');
             	    
                    $("#tableBody").append('<td>' + this.username + '</td>');
                    $("#tableBody").append('<td>' + this.filename + '</td>');
                 
                    $("#tableBody").append('</tr>');
             	    });  
             	    } else {             	            	
             	          $("#tableBody").append('<tr><th colspan ="4"><center>查询无数据</center></th></tr>');
             	    }
             	    }else{
             	          alert(data.errorMsg);
             	            }
             	      },
             	        error: function(e){
             	           alert("查询失败:" + e);
             	        }
             	    });
               });
        }
        
        //渲染完就执行
        $(function() {
        	
        	//生成底部分页栏
            $('#bottomTab').bootstrapPaginator(options);     
        	
        	buildTable("",1,10);//默认空白查全部
        	
            //创建结算规则
            $("#queryButton").bind("click",function(){
            	var userName = $("#textInput").val();	
            	buildTable(userName,1,PAGESIZE);
            });
        });
    </script>
</body>
</html>