package kienanblue.stands.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Kienan on 26/08/2017.
 */
public class GenerateBlockStateJson
{
    public GenerateBlockStateJson(String path, String name)
    {
        File file = new File(path, name+".json");
        if(!file.exists())
        {
            try
            {
                file.createNewFile();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
                this.write(file);
            }
        }
    }
    
    private void write(File file)
    {
        PrintWriter writer = null;
        try
        {
            writer = new PrintWriter(file);
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        this.writeJson(writer);
    }
    
    private void writeJson(PrintWriter writer)
    {
        writer.println('{');
        writer.println("    "+'"'+"forge_marker"+'"'+": 1,");
        writer.println("    "+'"'+"variants"+'"'+": {");
        writer.println("        "+'"'+"x"+'"'+": {");
        writer.println("            "+'"'+"false"+'"'+": {");
        writer.println("                "+'"'+"model"+'"'+": "+'"'+"stands:basket"+'"');
        writer.println("            },");
        writer.println("            "+'"'+"true"+'"'+": {");
        writer.println("                "+'"'+"model"+'"'+": "+'"'+"stands:basket"+'"'+", "+'"'+"y"+'"'+": 90");
        writer.println("            }");
        writer.println("        }");
        writer.println("    }");
        writer.println("}");
        writer.close();
    }
}
