function preview() {
    $("#preview_area").html(UE.getEditor('editor').getContent());
}
function collect(srcUrl) {
}
function copy() {
    copyStringToClipboard(UE.getEditor('editor').getContent())
}
function release(content) {
}