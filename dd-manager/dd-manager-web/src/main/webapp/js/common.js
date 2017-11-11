
var ddshop = {


    //点击左侧的导航树，添加选项卡
    registerMenuEvent: function () {

        var _this = this;
        console.log(_this)

        // 使用tree组件
        $("#menu .easyui-tree").tree({
            //节点
            onClick: function (node) {
                console.log(this);
                var href = node.attributes.href;
                var text = node.text;
                _this.addTabs(text, href);
            }
        })
    },

    //添加选项卡
    addTabs: function (title,href) {
        if ($('#tab').tabs('exists', title)) {
            $('#tab').tabs('select', title);
        } else {
            $('#tab').tabs('add', {
                title: title,
                href: href,
                closable: true
            });


        }
    }
}





