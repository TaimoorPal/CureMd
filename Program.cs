namespace TechLift_Task
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] names = {"Taimoor Ahmed", "Awais Pal", "Muaaz Ahmad", "Azam Butt", "Ahmed Hussain",
                                   "Muhammad Ibrahim", "Usman Gujjar", "Usama Iqbal", "Waleed Qaiser", "Shehzad Niaz",
                                   "Aqib Ali", "Danish Bismillah", "Talha Nawazish", "Saad Aslam", "Aleem Alam"};
            string[] cities = {"Lahore", "Islamabad", "Karachi", "Lahore", "Quetta"
                                    ,"Faisalabad", "Islamabad", "Karachi", "FATA", "Islamabad"
                                    ,"Lahore", "Lahore", "Peshawar", "Islamabad", "Lahore"};
            double[] cgpa = { 3.96, 2.94, 3.02, 3.47, 3.13, 2.1, 2.76, 3.33, 3.82, 3.59, 1.9, 2.3, 3.22, 3.66, 3.18 };
            List<Candidates> selected = new List<Candidates>();
            List<Candidates> above90 = new List<Candidates>();
            Dictionary<string, string> selectedCandidatesDict = new Dictionary<string, string>();

            Console.WriteLine("Selected Applicants from the Array are :");
            Console.WriteLine("-----------------------------------------");

            for (int i = 0; i < names.Length; i++)
            {
                Candidates applicants = new Candidates(names[i], cities[i].ToLower(), cgpa[i]);
                if (selectedCandidatesDict.ContainsKey(applicants.city))
                {
                    selectedCandidatesDict[applicants.city] = selectedCandidatesDict[applicants.city] + "\n" + (applicants.name);
                }
                if (!selectedCandidatesDict.ContainsKey(applicants.city))
                {
                    selectedCandidatesDict.Add(applicants.city, applicants.name);
                    Console.WriteLine(selectedCandidatesDict[applicants.city]);
                }
                if (applicants.cgpa >= 3.0)
                {
                    selected.Add(applicants);
                }
            }
            Console.WriteLine("-----------------------------------------");
            Console.WriteLine("Selected Candidates with marks greater or equal to 90 : ");
            Console.WriteLine("-----------------------------------------");
            for (int i = 0; i < selected.Count; i++)
            {
                Random ran = new Random();
                selected[i].SetApplicantMarks(ran.Next(90, 101));
                selected[i].SetApplicantMarks(ran.Next(90, 101));
                if ((Convert.ToDouble(selected[i].marks.Sum()) / 200) * 100 >= 90)
                {
                    Console.WriteLine(selected[i].name);
                    above90.Add(selected[i]);

                }
            }
            Console.WriteLine("-----------------------------------------");
            Console.WriteLine("Enter the City you want to shortlist applicants from : ");
            Console.WriteLine("-----------------------------------------");
            string city =  Console.ReadLine();
            Console.WriteLine(selectedCandidatesDict[city.ToLower()]);
            Console.WriteLine("-----------------------------------------");

            //var myList = a.ToList();

            //myList.Sort((pair1, pair2) => pair1.Value.CompareTo(pair2.Value));




            Console.ReadLine();
        }

    }
    public class Candidates
    {
        public string name;
        public string city;
        public double cgpa;
        public List<int> marks = new List<int>();

        public Candidates(string name, string city, double cgpa)
        {
            this.name = name;
            this.city = city;
            this.cgpa = cgpa;
        }

        public void SetApplicantMarks(int mark)
        {
            marks.Add(mark);

        }
    }
}