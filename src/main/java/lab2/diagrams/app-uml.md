```mermaid
classDiagram
    class App {
        -String menu
        -String addItemMenu
        -ArrayList saleableItems
        -Scanner input
        -PrintStream out
        
        +App()
        +App(InputStream in, PrintStream out)
        +run()
        +findItem(SaleableItem item)
        +editItem()
        +deleteItem()
        +populate()
        +listAny()
        +sellItem()
        +addItem()
        +addItem(SaleableItem s)
    }