<%--
  Created by IntelliJ IDEA.
  User: l
  Date: 2017/11/6
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>


<table id="dg"></table>

<script>
    <%--定义一个工具条--%>
    var toolbar = [
        {
            iconCls: 'icon-up',
            text: '上架',
            handler: function () {
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
        },
        {
            iconCls: 'icon-down',
            text: '下架',
            handler: function () {
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
        },
        {
            iconCls: 'icon-add',
            text: '新增',
            handler: function () {
                alert('新增')
            }
        },
        {
            iconCls: 'icon-edit',
            text: '修改',
            handler: function () {
                alert('修改')
            }
        },
        {
            iconCls: 'icon-remove',
            text: '删除',
            handler: function () {
                //alert('删除');
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
        }
    ]



    $('#dg').datagrid({

        //工具条
        toolbar:toolbar,
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
            {field: 'id', title: '商品编号', width: 100},
            {field: 'title', title: '商品名称', width: 100},
            {field: 'sellPoint', title: '卖点', width: 100},
            {field: 'catName', title: '分类名称', width: 100},
            {field: 'statusName', title: '商品状态', width: 100},
            {field: 'price', title: '价格', width: 100,formatter:function (value) {
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

