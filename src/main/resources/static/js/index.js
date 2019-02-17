function preview() {
    localStorage.setItem(key, UE.getEditor('editor').getContent());

    $("#preview_area").html(UE.getEditor('editor').getContent());
}

function collect() {
    srcUrl = document.getElementById("collect_input_url").value;
    if (srcUrl !== undefined && srcUrl !== "" && srcUrl.match("^https://.*$")) {
        $("#collectDialog").modal("hide");
        var collectRequest = {};
        collectRequest.srcUrl = srcUrl;
        $.ajax({
            url: '/editor/collect',
            type: 'POST',
            data: JSON.stringify(collectRequest),
            contentType: "application/json",
            dataType: 'json',
            success: function (data) {
                UE.getEditor('editor').setContent(data.htmlContent)
            },
            fail: function (xhr, textxStatus, errorThrown) {
                alert("发布失败")
            }
        });
    } else {
        alert("无效的url地址")
    }
}

function copy() {
    copyStringToClipboard(UE.getEditor('editor').getContent())
}

function release(content) {
    articleTitle = document.getElementById("article_title").value;
    if (articleTitle === undefined || articleTitle === "" || articleTitle.length > 64) {
        alert("文章名不合法");
        return
    }
    var releaseRequest = {};
    releaseRequest.articleTitle = article_title;
    releaseRequest.content = UE.getEditor('editor').getContent();
    $.ajax({
        url: '/editor/release',
        type: 'POST',
        data: JSON.stringify(releaseRequest),
        contentType: "application/json",
        success: function (data) {
            alert("发布成功")
        },
        fail: function (xhr, textxStatus, errorThrown) {
            alert("发布失败")
        }
    });
}