package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //ile yourFile = File.createTempFile("c:\\java\\temp.txt", null);
            File yourFile = new File("c:\\java\\temp.txt");
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            javaRush.users.add(user);

            user.setFirstName("firstName");
            user.setLastName("lastName");
            user.setBirthDate(new Date(77, 7, 1));
            user.setCountry(User.Country.RUSSIA);
            user.setMale(true);




            javaRush.save(outputStream);
            outputStream.flush();
            
            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println("equals?: " + javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            if (this.users.size() >0) {
                for (User u : this.users) {
                    writer.println(u.getFirstName());
                    writer.println(u.getLastName());
                    writer.println(u.getBirthDate().getTime());
                    writer.println(u.isMale());
                    writer.println(u.getCountry());
                }

                }else {
                System.out.println("users is null");
            }
            writer.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        while (reader.ready()) {
            User user = new User();
            String firstName;
            if ((firstName = reader.readLine())!=null){
                user.setFirstName(firstName);
            } else {
                user.setFirstName(null);
            }

            String lastName;
            if ((lastName = reader.readLine())!=null){
                user.setLastName(lastName);
            } else {
                user.setLastName(null);
            }

            String dat;
            if ((dat = reader.readLine())!=null){
                user.setBirthDate(new Date(Long.parseLong(dat)));
            } else {
                user.setBirthDate(null);
            }

            user.setMale(Boolean.parseBoolean(reader.readLine()));

            //user.setCountry(User.Country.valueOf(reader.readLine()));

            String country = reader.readLine();

            switch (country) {
                case "UKRAINE":
                    user.setCountry(User.Country.UKRAINE);
                    break;
                case "RUSSIA":
                    user.setCountry(User.Country.RUSSIA);
                    break;
                default:
                    user.setCountry(User.Country.OTHER);
                    break;
            }
            users.add(user);
        }
        reader.close();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JavaRush javaRush = (JavaRush) o;

        return users != null ? users.equals(javaRush.users) : javaRush.users == null;

    }

    @Override
    public int hashCode() {
        return users != null ? users.hashCode() : 0;
    }
}
}
