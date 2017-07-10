$( document ).ready(function() {
	
});

function getDeptDetail(deptId){
	$.ajax({
		  type: "GET",
		  dataType: "json",
		  url: "getDeptDetail",
		  data:{"id":deptId},
		  success:function(msg){ $('#testBody_'+ deptId).html('<tr><td>'+msg.desc +'</td></tr>');}
		});
}