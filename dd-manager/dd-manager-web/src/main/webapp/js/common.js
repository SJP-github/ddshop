
var ddshop = {

    //点击左侧的导航树，添加选项卡
    registerMenuEvent:function(){
        // 使用tree组件
        $("#menu .easyui-tree").tree({
            //节点
            onClick:function (node) {
                //console.log(node);
                var href=node.attributes.href;
                var text=node.text;
                $("#tab").tabs("close", 1);
                $("#tab").tabs("add", {
                    title: text,
                    href: href,
                    closable: true
                });
            }
        });
    }

};



