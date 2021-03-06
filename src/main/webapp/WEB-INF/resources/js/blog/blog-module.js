/**
 * Created by hunseol on 2017. 5. 25..
 */
/* Write here your custom javascript codes */
var csrfHeader=$("#csrfHeader").attr("content");
var	csrfToken=$("#csrfToken").attr("content");
var root="/shooney";

var BlogTypeService = (function () {
    var blogAdd = function () {
        var blogType = {}, blogTypeName;
        blogTypeName = $("input[name='name']").val();
        blogType["name"] = blogTypeName;
        $.ajax({
            url : root +"/admin/blog/type/insert",
            type : 'POST',
            timeout : 60000,
            data: JSON.stringify(blogType),
            dataType : "json",
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
                xhr.setRequestHeader(csrfHeader, csrfToken);
            }, success: function(data) {
                console.log("data", data);
                if(data.result=="success"){
                    alert("Success : Insert Blog Type")
                } else {
                    alert("Fail : Insert Blog Type");
                }
            }, error : function(error){
                console.log('Error', error);
            }
        });
    };

    return {
        blogAdd: blogAdd
    }
})();