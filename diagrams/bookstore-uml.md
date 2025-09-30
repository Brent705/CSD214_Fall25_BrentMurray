```mermaid
classDiagram
    class cashTill {
        +sellItem(SaleableItem item)
    }
    
    class SaleableItem {
        +sellItem()
        +getPrice()
    }
    <<interface>> SaleableItem
       
    class Publication {
        -String title
        -double price
        -int copies
        -int id
        +sellItem()
        +getPrice()
        +publication()
        +publication(String title, double price, int copies)
        +toString()
        +equals()
        +hashCode()
    }
    <<abstract>> Publication
    Publication ..|> SaleableItem
    Publication ..|> Serializable
    Publication ..|> Editable
    
    class Ticket {
        -int id
        -String description
        -double price
        +getPrice()
        +sellItem()
        +edit()
        +initalize()
    }
    <<abstract>> Ticket
    Ticket ..|> SaleableItem
    Ticket ..|> Serializable
    Ticket ..|> Editable
    
    class Editable {
         +String getInput(param: String)
         +String getInput(param: int)
         +String getInput(param: double)
         +String getInput(param: boolean)
         +String getInput(param: LocalDate)
         +edit()
         +initialize()
    }
    <<abstract>> Editable

    class Book {
        -author: String
        +edit()
        +initialize()
        +sellItem()
        +sellItem()
        +Book()
        +Book(String author)
        +Book(String author, String title, double price, int copies)
        +toString()
        +equals()
        +hashCode()
    }

    class Magazine {
        -int orderQty
        -java.time.LocalDate currentIssue
        +Magazine()
        +Magazine(int orderQty, Date currentIssue, String title, double price, int copies)
        +edit()
        +initialize()
        +sellItem()
    }

    class DiscMag {
        -boolean hasDisc
        +super.edit()
        +super.initialize()
        +super.sellItem()
        +DiscMag()
        +DiscMag(int orderQty, Date currentIssue, String title, double price, int copies)
    }
    DiscMag ..|> Magazine

    class Serializable {
    }
    <<interface>> Serializable

