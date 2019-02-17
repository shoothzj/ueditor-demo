function preview() {
    $("#preview_area").html(UE.getEditor('editor').getContent());
}
function collect(srcUrl) {
    var collectRequest = {

    };
    collectRequest.srcUrl = srcUrl;
    $.ajax({
        url : '/editor/collect',
        type : 'POST',
        data :  JSON.stringify(collectRequest),
        contentType: "application/json",
        dataType: 'json',
        success : function (data) {
            UE.getEditor('editor').setContent(data.htmlContent)
        },
        fail : function (xhr, textxStatus, errorThrown) {
            alert("发布失败")
        }
    });
}
function copy() {
    copyStringToClipboard(UE.getEditor('editor').getContent())
}
function release(content) {
    var releaseRequest = {

    };
    releaseRequest.content = UE.getEditor('editor').getContent();
    $.ajax({
        url : '/editor/release',
        type : 'POST',
        data :  JSON.stringify(releaseRequest),
        contentType: "application/json",
        success : function (data) {
            alert("发布成功")
        },
        fail : function (xhr, textxStatus, errorThrown) {
            alert("发布失败")
        }
    });
}