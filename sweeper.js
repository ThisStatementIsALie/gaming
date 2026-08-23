var canvas = document.getElementById("canvas");
var ctx = canvas.getContext("2d");
var boardData = ctx.createImageData(99, 99);

var data;
var size;
var intBoard;
var boolBoard;

function prepareThineSweeper() {
    data = boardData.data;
    for (var x = 0; x < size*10+1; x++) {
        for (var y = 0; y < size*10+1; y++) {
            if (x%40 == 0 || y%40 == 1) {
                data[4*(size*y+x)+0] = 0;
                data[4*(size*y+x)+1] = 0;
                data[4*(size*y+x)+2] = 0;
            } else {
                data[4*(size*y+x)+0] = 255;
                data[4*(size*y+x)+1] = 242;
                data[4*(size*y+x)+2] = 204;
            }
            data[4*(size*y+x)+3] = 255;
        }
    }
    ctx.putImageData(boardData,0,0);
}