<%--
  Created by IntelliJ IDEA.
  User: l
  Date: 2017/11/6
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<div class="easyui-panel" title="商品详情" data-options="fit:true">
    <form class="itemForm" id="itemAddForm" name="itemAddForm" method="post">
        <table style="width:100%;">
            <tr>
                <td class="label">商品类目：</td>
                <td>
                    <input id="cid" name="cid" style="width:200px;">
                </td>
            </tr>
            <tr>
                <td class="label">商品标题：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="title" name="title"
                           data-options="required:true" style="width:100%">
                </td>
            </tr>
            <tr>
                <td class="label">商品卖点：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="sellPoint" name="sellPoint"
                           data-options="validType:'length[0,150]',multiline:true" style="width:100%;height:60px;">
                </td>
            </tr>
            <tr>
                <td class="label">商品价格：</td>
                <td>
                    <input class="easyui-numberbox" type="text" id="priceView" name="priceView"
                           data-options="required:true,min:0,precision:2">
                    <input type="hidden" id="price" name="price">
                </td>
            </tr>
            <tr>
                <td class="label">商品库存：</td>
                <td>
                    <input class="easyui-numberbox" type="text" id="num" name="num"
                           data-options="required:true,min:0,precision:0">
                </td>
            </tr>
            <tr>
                <td class="label">条形码：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="barcode" name="barcode"
                           data-options="validType:'length[0,30]'">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <!-- 加载编辑器的容器 -->
                    <script id="container" name="content" type="text/plain">商品描述</script>
                </td>
            </tr>

            <tr class="paramsShow" style="display:none;">
                <td class="label">商品规格：</td>
                <td>

                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <button onclick="submitForm()" class="easyui-linkbutton" type="button"
                            data-options="iconCls:'icon-ok'">保存
                    </button>
                    <button onclick="clearForm()" class="easyui-linkbutton" type="button"
                            data-options="iconCls:'icon-undo'">重置
                    </button>
                </td>
            </tr>
        </table>
        <input name="paramData" id="paramData" style="display:none;">
    </form>
</div>

<script>

    //初始化之前删除原有的容器
    UE.delEditor('container')

    //富文本编辑器
    var ue = UE.getEditor('container',{
        initialFrameWidth: '100%',
        initialFrameHeight: '400'
    });


    //加载商品类目树型下拉框
    $("#cid").combotree({
        url:'itemCats?parentid=0',
        required:true,
        //展开前
        onBeforeExpand: function (node) {
            //获取当前被点击的tree
            var $currentTree = $('#cid').combotree('tree');
            //调用easyui tree组件的options方法
                                             //返回树控件属性#无参数
            var option = $currentTree.tree('options');
            //修改option的url属性
            option.url = 'itemCats?parentid=' + node.id;
        },
        //叶子节点选择前
        onBeforeSelect: function (node) {
            //判断选中节点是否为叶子节点，如果是，返回true
            var isLeaf = $('#cid').tree('isLeaf', node.target);
            //如果后台管理员选中的不是叶子节点的话，给出警告框
            if (!isLeaf) {
                $.messager.alert('警告', '请选中最终的类别！', 'warning');
                return false;
            }
        }
    })

    //保存商品
    function submitForm() {
        $("#itemAddForm").form('submit',{
            url:'item',
            //提交之前触发，返回false不触发
            onSubmit:function () {
                //将表单上的价格从元转化为分
                $('#price').val($('#priceView').val() * 100);
                return $(this).form('validate');

            },
            //成功之后的回到函数
            success:function(data){
                console.log(data);
                if(data>0){
                    $.messager.alert('消息','保存成功！','info');
                    ddshop.addTabs('查询商品', 'item-list');
                }

            }
        })

    }

    function clearForm() {
        $('#itemAddForm').form('reset');
        ue.setContent('商品描述');
    }


</script>