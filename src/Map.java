import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map extends Mapper<LongWritable, Text, Text, IntWritable> {

	private final static IntWritable one = new IntWritable(1);

	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		
		String line = value.toString();
		
		if (line.contains("[INFO]")){
			Text aux1 = new Text("[INFO]");
			context.write(aux1, one);
		}
		
		if (line.contains("[SERVERE]")){
			Text aux2 = new Text("[SERVERE]");
			context.write(aux2, one);
		}
		
		if (line.contains("[WARN]")){
			Text aux3 = new Text("[WARN]");
			context.write(aux3, one);
		}
		
	}
}