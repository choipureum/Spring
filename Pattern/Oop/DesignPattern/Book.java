package builder;

public class Book {

   //점층적 생성자 패턴 
   // 단점 : 생성자의 매개변수로 넘기는 데이터가 어떤 의미를
   // 지니는 지 알기 어렵다.
   
   // 자바 빈 패턴
   // 장점 : 각 인자의 의미를 파악하기 편하다.
   // 단점 : 객체의 일관성이 깨진다.
   // setter메서드가 있음으로 변경 불가능한 (immutable)클래스를
   //만들 수 없다.
   
   
   //builder 패턴

   private final String title;
   private final String author;
   private final String publisher;
   private final int page;
   
   private Book(BookBuilder builder){
      title = builder.title;
      author = builder.author;
      publisher = builder.publisher;
      page = builder.page;
   };
   
   
   
   public static class BookBuilder{
      
      private String title = "";
      private String author = "";
      private String publisher = "";
      private int page = 0;
      
      public BookBuilder title(String val) {
         title = val;
         return this;
      }
      
      public BookBuilder author(String val) {
         author = val;
         return this;
      }
      public BookBuilder publisher(String val) {
         publisher = val;
         return this;
      }
      public BookBuilder page(int val) {
         page = val;
         return this;
      }
      
      public Book build() {
         return new Book(this);
      }     
   }


   @Override
   public String toString() {
      return "Book [title=" + title + ", author=" + author + ", publisher=" + publisher + ", page=" + page + "]";
   }
   
   
}
