$(document).ready(function() { 
	$.ajax({
             type: "GET",
             url: "./price",
             data: {userid:$("#userid").text()},
             dataType: "json",
             success: function(data){
                        var x = [];
                        var y = [];
                        for(var d in data){
                         	for(var g in data[d]){
                         		temp = data[d][g].time;
                         		if(temp.split(" ")[0]!=data[d][g-1>=0?g-1:0].time.split(" ")[0]){
                         			x[g] = temp.substr(0,temp.length-5);
                         		}
                         		else{
                         			temp = temp.split(" ")[1].split(":");
                         			x[g] = temp[0]+":"+temp[1];
                         		}
                         		y[g] = data[d][g].price;
                         	}
                            $("#canvas").append('<h4>'+data[d][0].from+'  to  '+data[d][0].to+'</h4>');
                            $("#canvas").append('<canvas id="'+d+'" width="700" height="400"></canvas>');
                            var lineChartData = {
                                labels : x,
                                datasets : [
                                {
                                    fillColor : "rgba(151,187,205,0.5)",
                                    strokeColor : "rgba(151,187,205,1)",
                                    pointColor : "rgba(151,187,205,1)",
                                    pointStrokeColor : "#fff",
                                    data : y
                                }]
                            }
                            ctx = document.getElementById(d).getContext("2d");
                            var myLine = new Chart(ctx).Line(lineChartData); 	
                        }
                      }	
         });
}); 