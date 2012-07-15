$(document).ready(function() {
    $('#ajax').click(function(){ 
        alert('ajax');
         $.ajax({ 
             type: "GET",
             dataType: "json",
             url: "/StaplesCareers/resources/jobs",
             success: function(data){        
                alert(data);
             },
             failure: function(data){
                 alert(data);
             }
         });
    });    
    
    $('#example').dataTable( {
        "bProcessing": true,
        "bJQueryUI": true,
        "aLengthMenu": [[10, 25, 50, 100, 500, -1], [10, 25, 50, 100, 500, "All"]],
        "sAjaxSource": "/StaplesCareers/resources/jobs",
        "sAjaxDataProp": "Job",
        "aoColumns": [
            { "mDataProp": "jobNumber" },
            { "mDataProp": "titleEng" },
            { "mDataProp": "jobField" },
            { "mDataProp": "organization" },            
            { "mDataProp": "level4" },            
            { "mDataProp": "level3" },      
            { "mDataProp": "level2" },            
            { "mDataProp": "jobLevel" },
            { "mDataProp": "jobSchedule" }
        ],
        "sPaginationType": "full_numbers"
        //,"sDom": '<"top"iflp<"clear">>rt<"bottom"iflp<"clear">>'        
    });        
    
 });