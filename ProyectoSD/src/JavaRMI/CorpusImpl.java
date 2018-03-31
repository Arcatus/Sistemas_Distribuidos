
package JavaRMI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CorpusImpl extends java.rmi.server.UnicastRemoteObject implements corpusInterface 
{
    static String PATH = "corpusChistes.txt";
    
    public CorpusImpl() throws java.rmi.RemoteException
    {
        super();
    }
    @Override
    public List<String> main(String query,int num_consultas)
    {
        int size;
        String tokens[] = tokenizer(query);
        size = tokens.length;
        readCorpus(tokens,num_consultas);
        if (size == 1 || size == 3) {
            List<String> buffer = readCorpus(tokens,num_consultas);
            return buffer;
        }
        return null;
    }
    
    public static List<String> readCorpus(String[] query, int numero_consultas)
    {
        List<String> buffer = new ArrayList<String>(); 
        File file = new File(PATH);
        try {
        Scanner scanner = new Scanner(file);
        int index = 0 , limit = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine(); 
            line = line.toLowerCase();
            index++;
            if (query.length == 3) {
                if ("AND".equals(query[1].toUpperCase())) {
                    if(line.indexOf(query[0]) != -1 && line.indexOf(query[2]) != -1 ) {
                        buffer.add(line);
                        limit++; 
                    }
                } else if ("NOR".equals(query[1].toUpperCase())) {
                    if( !( line.indexOf(query[0]) != -1 || line.indexOf(query[2]) != -1 ) ) {
                        buffer.add(line);
                        limit++; 
                    }
                }
            } else if (query.length == 1) {
                if( line.indexOf(query[0]) != -1 ) {
                    buffer.add(line);
                    limit++; 
                }
            }
            if(limit >= numero_consultas ) { 
                break;
            }
        }
        } catch(FileNotFoundException e) { 
        System.err.println("No data" + e.getMessage()); 
        }
        return buffer;
    }
    
    public static String[] tokenizer(String query)
    {
        StringTokenizer st = new StringTokenizer(query);
        String buffer[] = new String[st.countTokens()]; 
        if (st.countTokens() == 3) {
            for (int i = 0 ; i < 3; i++)
            {
                buffer[i] = st.nextToken();
            }
        } else if (st.countTokens() == 1) {
            buffer[0] = st.nextToken();
        }
        return buffer;
    }
}