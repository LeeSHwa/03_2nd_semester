import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;

public class ChannelBufferEx {

    public static void main(String[] args) throws IOException {

        ByteBuffer buffer1 = ByteBuffer.allocate(100);

        System.out.println("buffer capacity=" + buffer1.capacity());
        System.out.println("buffer limit=" + buffer1.limit());
        System.out.println("buffer position=" + buffer1.position());
        System.out.println();

        buffer1.put((byte) 0x41);  // A
        buffer1.put((byte) 0x42);  // B

        System.out.println("buffer capacity=" + buffer1.capacity());
        System.out.println("buffer limit=" + buffer1.limit());
        System.out.println("buffer position=" + buffer1.position());
        System.out.println();

        buffer1.flip();
        System.out.println("after flip : buffer capacity=" + buffer1.capacity());
        System.out.println("buffer limit=" + buffer1.limit());
        System.out.println("buffer position=" + buffer1.position());
        System.out.println();

        WritableByteChannel output = Channels.newChannel(System.out);
        output.write(buffer1);

        System.out.println();
        System.out.println("after write : buffer limit=" + buffer1.limit());
        System.out.println("buffer position=" + buffer1.position());
        System.out.println();

        buffer1.limit(buffer1.capacity() - 10);
        buffer1.put((byte) 0x43);  // C

        System.out.println("after write C : buffer limit=" + buffer1.limit());
        System.out.println("buffer position=" + buffer1.position());
        System.out.println();

        buffer1.rewind();

        System.out.println("after rewind : buffer limit=" + buffer1.limit());
        System.out.println("buffer position=" + buffer1.position());
        System.out.println();

        buffer1.clear();

        System.out.println("after clear : buffer limit=" + buffer1.limit());
        System.out.println("buffer position=" + buffer1.position());
        System.out.println();

        buffer1.position(1);
        buffer1.limit(3);
        System.out.println(buffer1);
        byte[] array = buffer1.array();
        System.out.println(Arrays.toString(array));

        buffer1.compact();
        System.out.println(buffer1);
        array = buffer1.array();
        System.out.println(Arrays.toString(array));

        FileInputStream fin = new FileInputStream("data1.txt");
        FileChannel fc = fin.getChannel();
        ByteBuffer buffer2 = ByteBuffer.allocate(100);
        fc.read(buffer2);
        System.out.println(Arrays.toString(buffer2.array()));

        byte[] message = new String("test message").getBytes();
        FileOutputStream fout = new FileOutputStream("wrtiedata.txt");
        FileChannel fcout = fout.getChannel();
        ByteBuffer bufferout = ByteBuffer.allocate(1024);
        for (int i = 0; i < message.length; ++i) {
            bufferout.put(message[i]);
        }
        bufferout.flip();
        fcout.write(bufferout);
    }
}