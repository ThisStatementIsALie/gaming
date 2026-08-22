var board;
var data;
var size;
var intBoard;
var id;

function prepareThineSweeper(size, id) {
    this.id = id;
    this.size = size;
    board=ImageData.createImageData(size, size);
    blankBoard(id, size);
    document.getElementById(id).putImageData(board, 0,0)
}

function blankBoard(id, size) {
    data = board.data;
    for (var x = 0; x < size*10+1; x++) {
        for (var y = 0; y < size*10+1; y++) {
            if (x%10 == 0 || y%10 == 1) {
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
}