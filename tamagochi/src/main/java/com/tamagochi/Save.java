package com.tamagochi;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;

public interface Save {
    /*
     * A function who save the game ( the tamagochi class)
     * you need to implement this function in the tamagochi class and to implement Serializable
     * @return void
     * @param Tamagochi
    */
    public default void save(Tamagochi tama) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream outputStream = new ObjectOutputStream(baos);
            outputStream.writeObject(tama);
            byte[] data = baos.toByteArray();
            Files.write(Path.of("./save.dat"), data);
            baos.close();
            outputStream.close();
        }
        catch (Exception e) {
            System.out.println("Save error" + e);
        }
  
    };
    public default Tamagochi load() {
        Path filePath = Path.of("./save.dat");
        if(Files.exists(filePath) == true) {
            try{
                byte[] data = Files.readAllBytes(filePath);
                ByteArrayInputStream bais = new ByteArrayInputStream(data);
                ObjectInputStream ois = new ObjectInputStream(bais);
                Tamagochi tama = (Tamagochi) ois.readObject();
                bais.close();
                ois.close();
                if(tama.IsDead == true) {
                    return new Tamagochi();
                } else {
                    return tama;
                }
                
            }
            catch(ClassNotFoundException e){
                System.out.println("Save error" + e);
            }
            catch(IOException e){
                System.out.println("Save error" + e);
            } 
        }
        System.out.println("No save found");
        return new Tamagochi();
    };
}
