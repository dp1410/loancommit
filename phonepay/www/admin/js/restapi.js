var DefineRest=Vue.component("define-rest-view",{template:"#define-rest-view",data:()=>({rest:[],selected:{},entity:{}}),methods:{selectEndp(e){console.log(e.name),this.selected=e}},mounted(){let e=this;$.ajax({url:"/admin/restapi",type:"get",dataType:"json",success:function(t){console.log(t),e.rest=t.rest}})}}),ExecuteRest=Vue.component("execute-rest-view",{template:"#execute-rest-view",data:()=>({rest:[],selected:{},response:"response"}),computed:{pathParams(){if(this.selected){let e=[];return this.selected.pathParams.forEach(t=>e.push("")),e}return[]},queryParams(){if(this.selected){let e=[];return this.selected.queryParams.forEach(t=>e.push("")),e}return[]},requestBody(){if(this.selected){let e=JSON.parse(this.selected.entity);return Object.keys(e).reduce((t,s)=>(t[s]=e[s].value,t),{})}return{}}},methods:{getInputType(e){try{let t=JSON.parse(this.selected.entity)[e];return t&&t.type?t.type:"text"}catch(e){return console.log(e),"text"}},selectEndp(e){console.log(e.name),this.selected=e,this.response="response"},executeEndp(){let e=this,t=Object.keys(this.selected).reduce((e,t)=>"path"==t?(e.url=this.selected.path,e):"method"==t?(e.type=this.selected.method,e):"produces"==t?("text/plain"==this.selected.produces&&(e.dataType="plain"),"text/html"==this.selected.produces&&(e.dataType="html"),"application/json"==this.selected.produces&&(e.dataType="json"),"application/xml"==this.selected.produces&&(e.dataType="xml"),e):"consumes"==t?(e.contentType=this.selected.consumes,e):(e[t]=this.selected[t],e),{});if(t.success=function(t){e.response=t},t.error=function(t){e.response=t.responseText},this.selected.path){let s=this.selected.path.match(/{.*?}/g);s&&s.forEach(function(s,c){t.url=t.url.replace(s,e.pathParams[c])})}if(this.selected.query){let c=this.selected.query.match(/{.*?}/g);if(c){var s="?"+this.selected.query;c.forEach(function(t,c){s=s.replace(t,e.queryParams[c])}),t.url=t.url.concat(s)}}if(this.selected.entity&&("application/json"==this.selected.consumes?t.data=JSON.stringify(this.requestBody):"application/x-www-form-urlencoded"==this.selected.consumes&&(t.data=this.requestBody),"multipart/form-data"==this.selected.consumes)){let e=$("form.frm-execute-endpoint");var c=new FormData(e[0]);t.data=c,t.contentType=!1,t.cache=!1,t.processData=!1}$.ajax(t)}},mounted(){let e=this;$.ajax({url:"/admin/restapi",type:"get",dataType:"json",success:function(t){console.log(t),e.rest=t.rest}})}}),app=new Vue({el:"#app"});