package TestTask1;

class TestTask1 {

    /* "Почему данная реализация не обеспечивает желаемого? "
    - Ответ на этот вопрос в комментариях по ходу выполнения программы*/

    static class User{
        private long id;
        private String vacancy;
        /*" private Vacancy vacancy; " В классе Vacancy значально не хватало свойств,
         * чтобы тип переменной vacancy (передаваемой из объекта tester в соответствующий конструктор класса User)
         *  корректно обрабатывался компилятором, поэтому проще всего было указать тип данных String*/


        //В изначальном коде не было конструктора, в который должны были передаваться необходимые параметры.
        public User(long id, String vacancy) {
            this.id = id;
            this.vacancy = vacancy;
        }


        /* Изначально метод getVacancy() обращался к переменной vacancy и, судя по всему,
         вызывал сам себя и к класссу Vacancy никак не обращался.
         => необходимо обратиться к классу Vacancy и передать в метод getVacancy() значение переменной vacancy*/
        String getVacancy() {
            return Vacancy.getVacancy(vacancy);
        }

        long getId(){
            return id;
        }
    }


    /* Метод getVacancy() в классе Vacancy изначально возвращал значение "engineer",
     * хотя должен был возвращать значение получаемое из объекта tester класса User.*/
    static class Vacancy {
        static String getVacancy(String vacancy) {
            return vacancy;
        }
    }

    public static void main(String[] args) {
        User tester = new User(7, "Developer");
        System.out.println(tester.getId()); //Возврат id, присвоенного объекту tester
        System.out.println(tester.getVacancy()); //Возврат vacancy, присвоенного объекту tester

        //Проверка
        User tester2 = new User(10, "Junior Android Developer");
        System.out.println(tester2.getId());
        System.out.println(tester2.getVacancy());
    }
}
