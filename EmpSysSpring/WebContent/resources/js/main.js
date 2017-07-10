$(document).ready(function() {
	
});

function deleteEmp(empId) {
	$.ajax({
		type: "DELETE",
		dataType: "text",
		url: "deleteEmp",
		data: {"id": empId},
		success:function() {
			alert("Delete Successful");
		}
	});
}