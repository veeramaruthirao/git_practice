var chartdataStr = decodeHTML(chartData);
var chartJsonArray = JSON.parse(chartdataStr);


var arrayLength = chartJsonArray.length;
var numericData = [];
var labelData = [];

for(var i=0;i<arrayLength;i++){
	numericData[i] =chartJsonArray[i].value;
	labelData[i] = chartJsonArray[i].label;
}



var ctx = document.getElementById('mychart');
var mychart = new Chart(ctx, {
    type: 'pie',
    data: {
        labels: labelData,
        datasets: [{
            label: '# of Votes',
            data: numericData,
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
/*            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
*/            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});


function decodeHTML(html){
	var txt = document.createElement("textarea")
	txt.innerHTML = html;
	return txt.value;
}