# Καλώς Ήλθατε στο QuizBomb!

To QuizBomb είναι ένα διαδικτυακό φροντιστήριο, στο οποίο εάν είσαι καθηγητής μπορείς να ανεβάσεις ερωτήσεις και διαγωνίσματα ή να εμπλουτίσεις – δοκιμάσεις τις γνώσεις σου εάν είσαι μαθητής.

Οποιοσδήποτε μπορεί να γίνει, δωρεάν και χωρίς κάποια συνδρομή, μέλος αυτής της κοινότητας, εφόσον εγκριθεί η εγγραφή του από τον διαχειριστή (controller).
Ο διαχειριστής είναι υπεύθυνος για τον έλεγχο αξιοπιστίας των μελών, της εγκυρότητας του εκπαιδευτικού υλικού των καθηγητών και της αξιολόγησης των απαντήσεων των μαθητών.

Κάθε μέλος αυτής της κοινότητας, έχει το δικό του προφίλ με τα δικά του στοιχεία εισόδου.
Έτσι λοιπόν, εάν είσαι καθηγητής, μπορείς να ανεβάσεις στο προφίλ τo υλικό σου (π.χ. ερωτήσεις ) και βάση αυτού να δημιουργήσεις quizzes για τους μαθητές που είναι εγγεγραμμένοι στο μάθημα σου.
Εάν είσαι μαθητής, κάνεις login, και,  αφού έχεις κάνει εγγραφή σε μία τάξη, μπορείς να δοκιμάσεις τις γνώσεις σου στα αντίστοιχα quizzes.

Στο QuizBomb η εκπαίδευση γίνεται παιχνίδι και το παιχνίδι γίνεται εκπαίδευση!

*Μια απλή εγγραφή θα σε πείσει.!*


## Τεχνολογίες

* [Spring MVC](http://projects.spring.io/spring-framework/)
* [Spring Data JPA](http://projects.spring.io/spring-data-jpa/)
* [Hibernate ORM](http://hibernate.org/orm/)
* [MySQL](https://www.mysql.com/)
* [JFreeChart](http://www.jfree.org/jfreechart/)
 
 
## Οδηγίες Εγκατάστασης
* Εγκατάσταση [MySQL](https://www.mysql.com/)
* Εισαγωγή πινάκων και αρχικών εγγραφών στη βάση δεδομένων από αυτό το [sql script](https://raw.githubusercontent.com/QuizBomb/QuizBomb.app/master/src/main/resources/scripts/FinalScript-DBinitialization.sql)
* Ανανέωση στοιχείων σύνδεσης με τη βάση σε αυτό το [αρχείο](https://github.com/QuizBomb/QuizBomb.app/blob/master/src/main/resources/properties/datasource.properties)
* Δημιουργία war αρχείου της εφαρμογής 
 * [Εδώ](http://www.codejava.net/ides/eclipse/eclipse-create-deployable-war-file-for-java-web-application) περιγράφεται η διαδικασία δημιουργίας στο [Eclipse](http://www.eclipse.org/)
* Deploy war αρχείου στον web server της επιλογής σας