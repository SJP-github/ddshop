<%--
  Created by IntelliJ IDEA.
  User: l
  Date: 2017/11/6
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<div id="toolbar">
    <div style="padding: 5px; background-color: #fff;">
        <label>商品标题：</label>
        <input class="easyui-textbox" type="text" id="title">
        <label>商品状态：</label>
        <select id="status" class="easyui-combobox" >
            <option value="0">全部</option>
            <option value="1">正常</option>
            <option value="2">下架</option>
        </select>
        <!--http://www.cnblogs.com/wisdomoon/p/3330856.html-->
        <!--注意：要加上type="button",默认行为是submit-->
        <button onclick="searchForm()" type="button" class="easyui-linkbutton">搜索</button>
    </div>
    <div>
        <button onclick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</button>
        <button onclick="edit()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</button>
        <button onclick="remove()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</button>
        <button onclick="down()" class="easyui-linkbutton" data-options="iconCls:'icon-down',plain:true">下架</button>
        <button onclick="up()" class="easyui-linkbutton" data-options="iconCls:'icon-up',plain:true">上架</button>
    </div>
</div>
<table id="dg"></table>

<script>
    
    //搜索
    function searchForm() {
        $("#dg").datagrid('load', {
            title:$('#title').val(),
            status:$('#status').combobox('getValue')
        });
    }
    
    function  add() {
        ddshop.addTabs('新增商品','item-add');
    }

    function  edit() {

    }

    function  remove() {
        //获取用户选中的行
        var selectRows=$('#dg').datagrid('getSelections');
        console.log(selectRows);
        if(selectRows.length==0) {
            $.messager.alert("提示", "未选中任何记录", "warning");
            return;
        }

        $.messager.confirm("删除", "确认删除吗？", function (r) {
            if(r){
                //定义一个数据保存要删除的行的id
                var ids = [];
                for(var i=0;i<selectRows.length;i++) {
                    //保存要删除的id
                    ids.push(selectRows[i].id);
                }

                //使用ajax提交到后台处理
                $.post(

                    //url
                    'items/batch',
                    //data
                    {'ids[]':ids},
                    //callback
                    function (data) {
                        $('#dg').datagrid('reload');
                    },
                    //response
                    'json'
                );
            }
        });
    }

     //上架商品
    function  up() {
        //获取用户选中的数据
        var selectRows = $('#dg').datagrid('getSelections');
        console.log(selectRows);
        if(selectRows.length==0) {
            $.messager.alert("提示", "您未选中任何数据", "warning");
            return;
        }

        $.messager.confirm("上架","您要上架该商品吗？",function (r) {
            if (r){
                //保存要上架的商品id
                var ids = [];
                for(var i=0;i<selectRows.length;i++) {
                    ids.push(selectRows[i].id);
                }
                //异步提交请求
                $.post(
                    //url
                    'items/batchUp',
                    //data
                    {'ids[]':ids},
                    //callback
                    function (data) {
                        $('#dg').datagrid('reload');
                    },
                    //dataType
                    'json'
                );
            }
        })
    }

     //下架商品
    function  down() {
        //1.获取用户选中的数据
        var selectRows = $("#dg").datagrid('getSelections');
        console.log(selectRows);
        //2.判断用户是否选中数据
        if(selectRows.length==0) {
            $.messager.alert("提示","您未选中任何要操作的记录","warning")
            return;
        }

        //如果用户选中数据，进行提示，是否进行操作
        $.messager.confirm("下架","您确定要下架商品吗？",function (r) {
            if (r){
                var ids = [];
                for(var i=0;i<selectRows.length;i++) {
                    ids.push(selectRows[i].id);
                }

                //异步提交
                $.post(
                    'items/batchDown',
                    {"ids[]":ids},
                    function (data) {
                        $("#dg").datagrid('reload');
                    },
                    'json'
                );
            }
        });
    }


    $('#dg').datagrid({

        //多列排序
        multiSort:true,
        //工具条
        toolbar:'#toolbar',
        //请求远程服务器上的URL http://localhost:8080/ddshop/items
        url: 'items',
        //隔行变色，斑马线效果
        striped: true,
        //添加分页工具栏
        pagination: true,
        //每行的前面显示行号
        rownumbers: true,
        //使得数据表格自适应填充父容器
        fit: true,
        //默认显示10条，这样的话就显示20条
        pageSize: 20,
        //分页列表
        pageList: [6, 8, 10, 15, 20],
        //列属性
        columns: [[
            //field title width列属性
            {field: 'ck', checkbox: true},
            {field: 'id', title: '商品编号', width: 100, sortable:true},
            //组合排序
            {field: 'title', title: '商品名称', width: 100,sortable:true},
            {field: 'sellPoint', title: '卖点', width: 100},
            {field: 'catName', title: '分类名称', width: 100},
            {field: 'statusName', title: '商品状态', width: 100},
            //组合排序
            {field: 'price', title: '价格', width: 100,sortable:true,formatter:function (value) {
                //将价格格式化为常见格式
                return parseFloat(value/100).toFixed(2);
            }},
            {field: 'created', title: '创建时间', width: 100,formatter:function (value) {
                return moment(value).format('L');
            }},
            {field: 'updatedFormat', title: '更新时间', width: 100}
        ]]
    });


</script>

