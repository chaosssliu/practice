$( document ).ready(function() {
	
});

function getDeptDetails(deptId){
	$.ajax({
		  type: "GET",
		  dataType: "json",
		  url: "getDeptDetails",
		  data:{"id":deptId},
		  success:function(msg){ $('#testBody_'+ deptId).html('<tr><td>'+msg.desc +'</td></tr>');}
		});
}