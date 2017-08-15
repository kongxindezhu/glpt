<!DOCTYPE html>
<html lang="zh-cn">
	<head>
		<meta charset="utf-8" />
		<title>字典项列表</title>
		<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
		<link   rel="icon" href="${basePath}/favicon.ico" type="image/x-icon" />
		<link   rel="shortcut icon" href="${basePath}/favicon.ico" />
		<link href="${basePath}/js/common/bootstrap/3.3.5/css/bootstrap.min.css?${_v}" rel="stylesheet"/>
		<link href="${basePath}/css/common/base.css?${_v}" rel="stylesheet"/>
		<script  src="${basePath}/js/common/jquery/jquery1.8.3.min.js"></script>
		<script  src="${basePath}/js/common/layer/layer.js"></script>
		<script  src="${basePath}/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script  src="${basePath}/js/shiro.demo.js"></script>
		<script >
			so.init(function(){
				//初始化全选。
				so.checkBoxInit('#checkAll','[check=box]');
				
				<@shiro.hasPermission name="/dic/deleteDicItemById.shtml">
				//全选
				so.id('deleteAll').on('click',function(){
					var checkeds = $('[check=box]:checked');
					if(!checkeds.length){
						return layer.msg('请选择要删除的选项。',so.default),!0;
					}
					var array = [];
					checkeds.each(function(){
						array.push(this.value);
					});
					return deleteById(array);
				});
				</@shiro.hasPermission>
			});
			<@shiro.hasPermission name="/dic/deleteDicItemById.shtml">
			<#--根据ID数组删除角色-->
			function deleteById(ids){
				var index = layer.confirm("确定这"+ ids.length +"个字典类别？",function(){
					var load = layer.load();
					$.post('${basePath}/dic/deleteDicItemById.shtml',{ids:ids.join(',')},function(result){
						layer.close(load);
						if(result && result.status != 200){
							return layer.msg(result.message,so.default),!0;
						}else{
							layer.msg(result.resultMsg);
							setTimeout(function(){
								$('#formId').submit();
							},1000);
						}
					},'json');
					layer.close(index);
				});
			}
			</@shiro.hasPermission>
			<@shiro.hasPermission name="/dic/addDicItem.shtml">
			<#--添加角色-->
			function addRole(){
				var catalogId = $('#catalogId').val(),
					catalogName = $('#catalogName').val();
				/* if(!/^[a-z0-9A-Z]$/.test(type)){
					return layer.msg('类型Id为数字字母。',so.default),!1;
				} */
				if($.trim(catalogId) == ''){
					return layer.msg('类型Id不能为空。',so.default),!1;
				}
				if($.trim(catalogName) == ''){
					return layer.msg('类型名称不能为空。',so.default),!1;
				}
				
				<#--loading-->
				var load = layer.load();
				$.post('${basePath}/dic/addDicDicItem.shtml',{catalogId:catalogId,catalogName:catalogName},function(result){
					layer.close(load);
					if(result && result.status != 200){
						return layer.msg(result.message,so.default),!1;
					}
					layer.msg('添加成功。');
					setTimeout(function(){
						$('#formId').submit();
					},1000);
				},'json');
			}
			</@shiro.hasPermission>
		</script>
	</head>
	<body data-target="#one" data-spy="scroll">
		<#--引入头部: index=4表示导航停在第4页上-->
		<@_top.top 4/>
		<div class="container" style="padding-bottom: 15px;min-height: 300px; margin-top: 40px;">
			<div class="row">
				<#--引入左侧菜单：index=2表示导航停在第2页上-->
				<@_left.dic 2/>
				<div class="col-md-10">
					<h2>字典项列表</h2>
					<hr>
					<form method="post" action="" id="formId" class="form-inline">
						<div clss="well">
					      <div class="form-group">
					        <input type="text" class="form-control" style="width: 300px;" value="${findContent?default('')}" 
					        			name="findContent" id="findContent" placeholder="输入字典项ID或者名称">
					      </div>
					     <span class="">
				         	<button type="submit" class="btn btn-primary">查询</button>
				         	
				         		<a class="btn btn-success" onclick="showAddDialog();">增加类别</a>
				         	
				         	
				         		<button type="button" id="deleteAll" class="btn  btn-danger">删除</button>
				         	
				         </span>    
				        </div>
					<hr>
					<table class="table table-bordered">
						<tr>
							<th><input type="checkbox" id="checkAll"/></th>
							<th>字典项ID</th>
							<th>字典项名称</th>
							<th>字典类别</th>
							<th>操作</th>
						</tr>
						<#if page?exists && page.list?size gt 0 >
							<#list page.list as it>
								<tr>
									<td><input value="${it.id}" check='box' type="checkbox" /></td>
									<td>${it.itemId?default('-')}</td>
									<td>${it.itemName?default('-')}</td>
									<td>${it.uDicCatalog.catalogName?default('-')}</td>
									<td>
										<i class="glyphicon glyphicon-detail"></i><a href="javascript:deleteById([${it.id}]);">删除</a>
									</td>
								</tr>
							</#list>
						<#else>
							<tr>
								<td class="text-center danger" colspan="5">没有找到字典项</td>
							</tr>
						</#if>
					</table>
					<#if page?exists>
						<div class="pagination pull-right">
							${page.pageHtml}
						</div>
					</#if>
					</form>
				</div>
			</div><#--/row-->
			
			
				<#--添加弹框-->
				<div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="addroleLabel">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				        <h4 class="modal-title" id="addItemLabel">添加字典项</h4>
				      </div>
				      <div class="modal-body">
				        <form id="addForm" method="post">
				          <div class="form-group">
				            <label for="recipient-name" class="control-label">所属字典类别:</label>
				            <select id="catalogId" name="catalogId" class="form-control">
						    </select>
				          </div>
				          <div class="form-group">
				            <label for="recipient-name" class="control-label">字典项ID:</label>
				            <input type="text" class="form-control" name="itemId" id="itemId" placeholder="请输入字典项ID"/>
				          </div>
				          <div class="form-group">
				            <label for="recipient-name" class="control-label">字典项名称:</label>
				            <input type="text" class="form-control" id="itemName" name="itemName"  placeholder="请输入字典项名称">
				          </div>
				        </form>
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				        <button type="button" onclick="addItem();" class="btn btn-primary">保存</button>
				      </div>
				    </div>
				  </div>
				</div>
				<#--/添加弹框-->
			
			
		</div>
	</body>
	<script type="text/javascript">
	function showAddDialog(){
		$("#catalogId").empty();
		$.ajax({
			type: 'get',
	        url: '${basePath}/dic/queryCatalogList.shtml',
	        cache: false,
	        data: {},
	        dataType: 'json',
	        success: function(data){
	        	var catalogList = data.catalogList;
	        	if(catalogList!=null){
	        		for(var i=0;i<catalogList.length;i++){
	        			$("#catalogId").append("<option value='"+ catalogList[i].catalogId +"'>"+catalogList[i].catalogName+"</option>");
	        		}
	        	}
	        }
		});
		$('#add').modal();
	}
	
	function addItem(){
		if(checkItem()==true){
			$("#addForm").submit();
			location.href = "${basePath}/dic/item.shtml";
		}
	}
	
	function addItem(){
		var catalogId = $("#catalogId").val();
		var itemId = $("#itemId").val();
		var itemName = $("#itemName").val();
		if($.trim(catalogId) == ''){
			return layer.msg('字典类型不能为空。',so.Default),!1;
		}
		if($.trim(itemId) == ''){
			return layer.msg('字典项ID不能为空。',so.Default),!1;
		}
		if($.trim(itemName) == ''){
			return layer.msg('字典项名称不能为空。',so.Default),!1;
		}
		var load = layer.load();
		$.post('${basePath}/dic/addCatalogItem.shtml',{catalogId:catalogId,itemId:itemId,itemName:itemName},function(result){
			layer.close(load);
			if(result && result.status != 200){
				return layer.msg(result.message,so.Default),!1;
			}
			layer.msg('添加成功。');
			setTimeout(function(){
				$('#formId').submit();
			},1000);
		},'json');
	}
	
	
	</script>
</html>