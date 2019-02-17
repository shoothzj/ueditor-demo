//缩进,
UE.registerUI('indentation', function (editor, uiName) {
    //注册按钮执行时的command命令，使用命令默认就会带有回退操作
    editor.registerCommand(uiName, {
        execCommand: function (g, b) {
            this.execCommand("paragraph", "p", {
                style: "text-indent:" + (b + "em")
            });
        },
        queryCommandValue: function () {
            var g = k.filterNodeList(this.selection.getStartElementPath(), "p h1 h2 h3 h4 h5 h6");
            return g && g.style.textIndent && parseInt(g.style.textIndent) ? 1 : 0
        }
    });


    var items = [];
    fontItems = [0, 1, 2, 3, 5, 7, 10, 13, 15, 17, 20];
    for (var i = 0; i < fontItems.length; i++) {
        ci = fontItems[i];
        items.push({
            //显示的条目
            label: '缩进:' + ci + 'px',
            //选中条目后的返回值
            value: ci,
            renderLabelHtml: function () {
                return '<div class="edui-label %%-label" style="text-align:left;line-height:1;padding:3px 5px;font-size:12px;">' + (this.label || "") + '</div>';
            }
        });
    }
    //创建下来框
    var combox = new UE.ui.Combox({
        //需要指定当前的编辑器实例
        editor: editor,
        //添加条目
        items: items,
        //当选中时要做的事情
        onselect: function (t, index) {
            //拿到选中条目的值
            editor.execCommand("indentation", this.items[index].value);
        },
        //提示
        title: "调整缩进长度",
        //当编辑器没有焦点时，combox默认显示的内容
        initValue: "缩进"
    });

    editor.addListener('selectionchange', function (type, causeByUi, uiReady) {
        if (!uiReady) {
            var state = editor.queryCommandState(uiName);
            if (state === -1) {
                combox.setDisabled(true);
            } else {
                combox.setDisabled(false);
                var value = editor.queryCommandValue(uiName);
                if (!value) {
                    combox.setValue("缩进");
                    return;
                }
                //ie下从源码模式切换回来时，字体会带单引号，而且会有逗号
                value && (value = value.replace(/['"]/g, '').split(',')[0]);
                combox.setValue(value);

            }
        }

    });
    return combox;
});