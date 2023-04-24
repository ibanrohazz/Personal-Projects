const grid = document.getElementById("grid");
let lockGame = false;
// Set test mode to true if you want see mines location

const width = 30;
const height = 15;
const mineCount = 100;

const testMode = false;

generateGrid();

/* Create a grid of width x height */
function generateGrid() {
    lockGame = false;
    grid.innerHTML = "";
    for (var i = 0; i < height; i++) {
        row = grid.insertRow(i);
        for (var j = 0; j < width; j++) {
            cell = row.insertCell(j);
            cell.onclick = function () { init(this); };
            var mine = document.createAttribute("mine");
            mine.value = "false";
            cell.setAttributeNode(mine);
        }
    }
    generateMines();
}

/* Generates mines at random */
function generateMines() {
    for (var i = 0; i < mineCount; i++) {
        var row = Math.floor(Math.random() * height);
        var col = Math.floor(Math.random() * width);
        var cell = grid.rows[row].cells[col];
        cell.setAttribute("mine", "true");
        if (testMode) {
            cell.innerHTML = "X";
        }
    }
}

/* Highlight all the mines in red */
function revealMines() {
    for (var i = 0; i < height; i++) {
        for (var j = 0; j < width; j++) {
            var cell = grid.rows[i].cells[j];
            if (cell.getAttribute("mine") == "true") {
                cell.className = "mine";
            }
        }
    }
}

function checkGameComplete() {
    var gameComplete = true;
    for (var i = 0; i < height; i++) {
        for (var j = 0; j < width; j++) {
            if ((grid.rows[i].cells[j].getAttribute("mine") == "false") && (grid.rows[i].cells[j].innerHTML == "")) {
                gameComplete = false;
            }
        }
    }
    if (gameComplete) {
        alert("You Found All Mines!");
        revealMines();
    }
}

function init(cell) {
    // Check game completed or no
    if (lockGame) {
        return;
    } else {
        // Check user clicked on mine
        if (cell.getAttribute("mine") == "true") {
            revealMines();
            lockGame = true;
        } else {
            cell.className = "active";
            // Display number of mines around cell if cell don't have mine leave it empty
            var mineCount = 0;
            var cellRow = cell.parentNode.rowIndex;
            var cellCol = cell.cellIndex;
            for (var i = Math.max(cellRow - 1, 0); i <= Math.min(cellRow + 1, height-1); i++) {
                for (var j = Math.max(cellCol - 1, 0); j <= Math.min(cellCol + 1, width-1); j++) {
                    if (grid.rows[i].cells[j].getAttribute("mine") == "true") {
                        mineCount++;
                    }
                }
            }
            cell.innerHTML = mineCount;
            if (mineCount == 0) {
                // if cell don't have mine
                for (var i = Math.max(cellRow - 1, 0); i <= Math.min(cellRow + 1, height-1); i++) {
                    for (var j = Math.max(cellCol - 1, 0); j <= Math.min(cellCol + 1, width-1); j++) {
                        if (grid.rows[i].cells[j].innerHTML == "") {
                            init(grid.rows[i].cells[j]);
                        }
                    }
                }
            }
            checkGameComplete();
        }
    }

}