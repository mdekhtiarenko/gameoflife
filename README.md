#Game of Life
#### Requirements: JDK17

#### Results demonstration(first 5 generation when starting with glider pattern)
![Alt text](results/Generation1.png?raw=true "Generation 1")
![Alt text](results/Generation2.png?raw=true "Generation 2")
![Alt text](results/Generation3.png?raw=true "Generation 3")
![Alt text](results/Generation4.png?raw=true "Generation 4")
![Alt text](results/Generation5.png?raw=true "Generation 5")

## Rules
The universe of the Game of Life is an infinite two-dimensional orthogonal grid of square cells, each of which is in one of two possible states, alive or dead. Every cell interacts with its eight neighbors, which are the cells that are horizontally, vertically, or diagonally adjacent.
Rules

At each step in time, the following transitions occur:
1. Any live cell with fewer than two live neighbors dies as if caused by underpopulation.
2. Any live cell with two or three live neighbors lives on to the next generation.
3. Any live cell with more than three live neighbors dies, as if by overcrowding.
4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

The initial pattern constitutes the seed of the system. The first generation is created by applying the above rules simultaneously to every cell in the seed—births and deaths occur simultaneously, and the discrete moment at which this happens is sometimes called a tick (in other words, each generation is a pure function of the preceding one). The rules continue to be applied repeatedly to create further generations.
