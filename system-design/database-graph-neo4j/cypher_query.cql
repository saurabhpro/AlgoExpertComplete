// populate data

// company
CREATE (facebook:Company {name:'Facebook'})

// job seeking candidates
CREATE (saurabh:Candidate {name:'Saurabh'})
CREATE (amrita:Candidate {name:'Amrita'})
CREATE (divya:Candidate {name:'Divya'})

// interviewers
CREATE (alex:Interviewer {name:'Alex'})
CREATE (meghan:Interviewer {name:'Meghan'})
CREATE (marli:Interviewer {name:'Marli'})
CREATE (sandeep:Interviewer {name:'Sandeep'})
CREATE (molly:Interviewer {name:'Molly'})
CREATE (akshay:Interviewer {name:'Akshay'})
CREATE (aditya:Interviewer {name:'Aditya'})
CREATE (brandon:Interviewer {name:'Brandon'})
CREATE (pedro:Interviewer {name:'Pedro'})
CREATE (ryan:Interviewer {name:'Ryan'})
CREATE (xi:Interviewer {name:'Xi'})
CREATE (simran:Interviewer {name:'Simran'})
CREATE (amanda:Interviewer {name:'Amanda'})

// relations - who interviewed whom and the interview result
CREATE (alex)-[:INTERVIEWED {result:'passed'}]->(saurabh)
CREATE (meghan)-[:INTERVIEWED {result:'passed'}]->(saurabh)
CREATE (simran)-[:INTERVIEWED {result:'passed'}]->(saurabh)
CREATE (molly)-[:INTERVIEWED {result:'failed'}]->(saurabh)

CREATE (marli)-[:INTERVIEWED {result:'failed'}]->(amrita)
CREATE (akshay)-[:INTERVIEWED {result:'passed'}]->(amrita)
CREATE (aditya)-[:INTERVIEWED {result:'passed'}]->(amrita)
CREATE (meghan)-[:INTERVIEWED {result:'passed'}]->(amrita)
CREATE (brandon)-[:INTERVIEWED {result:'passed'}]->(amrita)

CREATE (marli)-[:INTERVIEWED {result:'failed'}]->(divya)
CREATE (meghan)-[:INTERVIEWED {result:'failed'}]->(divya)
CREATE (brandon)-[:INTERVIEWED {result:'passed'}]->(divya)
CREATE (xi)-[:INTERVIEWED {result:'failed'}]->(divya)

// relations - interviewers who gave interview in Facebook
CREATE (ryan)-[:APPLIED {status:'rejected'}]->(facebook)
CREATE (simran)-[:APPLIED {status:'accepted'}]->(facebook)
CREATE (xi)-[:APPLIED {status:'rejected'}]->(facebook)
CREATE (molly)-[:APPLIED {status:'rejected'}]->(facebook)
CREATE (alex)-[:APPLIED {status:'rejected'}]->(facebook)


// find the intetviewers who interviewed and failed Saurabh
// and who themselves applied to and got rejected by Facebook

MATCH (Interviewer:Interviewer)-[:INTERVIEWED {result:'failed'}]->(:Candidate {name:'Saurabh'})
WHERE (Interviewer)-[:APPLIED {status:'rejected'}]->(:Company {name:'Facebook'})
RETURN Interviewer // .name