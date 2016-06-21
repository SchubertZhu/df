
package io.example.cassandra.service;

import org.apache.flink.api.java.tuple.Tuple2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.example.cassandra.model.TransactionSnapshot;
import io.example.cassandra.repository.TransactionSnapshotRepo;

@Service
public class TransactionSnapshotService {
	
	
	private static final Logger LOG = LoggerFactory.getLogger(TransactionSnapshotService.class);
	
	@Autowired
	TransactionSnapshotRepo transactionSnapshotRepo;
	
	public void persist(Tuple2<String, Float> tuple){
		
		final TransactionSnapshot ts = new TransactionSnapshot(tuple.getField(0), tuple.getField(1));
		transactionSnapshotRepo.save(ts);
		
	}

}
