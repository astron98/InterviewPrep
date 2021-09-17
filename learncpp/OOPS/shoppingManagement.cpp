#include<bits/stdc++.h>

using namespace std;

#define MAX 100

class itemEntry
{
public:
	string itemName;
	string company;
	float unitPrice;
	int copies;
};

class Store {
public:
	int numItem;
	itemEntry database[MAX];

	Store() {
		numItem = 0;	// initialize the current number of items to 0
	}

	void insertItem(string &itemName, string &company, int copies, float unitPrice);
	void deleteItem(string &itemName);
	itemEntry* searchItem(string &itemName);
	void updateItem(string &itemName, int total, float price);
};

void Store::insertItem(string &itemName, string &company, int copies, float unitPrice) {
	database[numItem].itemName = itemName;
	database[numItem].company = company;
	database[numItem].copies = copies;
	database[numItem].unitPrice = unitPrice;

	printf("Items added successfully!\n");
	++numItem;
}

void Store::deleteItem(string &itemName) {
	for (int i = 0; i < numItem; i++) {
		if ((database[i].itemName).compare(itemName)) {
			database[i].copies--;
			printf("Item deleted!\n");
			return;
		}
	}

	printf("Item not found!\n");
}

itemEntry* Store::searchItem(string &itemName) {
	for (int i = 0; i < numItem; i++) {
		if ((database[i].itemName).compare(itemName)) {
			return &database[i];
		}
	}

	return NULL;
}

void Store::updateItem(string &itemName, int total, float price) {
	itemEntry* findItem = searchItem(itemName);

	if (!findItem) {
		printf("Item not found\n");
		return;
	}

	findItem->copies += total;
	findItem->unitPrice = price;
	printf("Details of the item is updated!\n");
}

int main() {

	Store obj;
	// clrscr();

	string option;
	string itemName, company, copies, unitPrice;

	while (option[0] != 'e') {
		cout << "\n----------->Enter your choice:<------------\n";
		cout << "I for insert\n";
		cout << "D for delete\n";
		cout << "S for search\n";
		cout << "U for update\n";
		cout << "E for exit\n";

		getline(cin,option);

		switch (option[0]) {
		case 'i':
			cout << "Enter Name of Item, Company and no of copies,Unit price  per line:\n";
			getline(cin, itemName);
			getline(cin, company);
			getline(cin, copies);
			getline(cin, unitPrice);
			obj.insertItem(itemName, company, stoi(copies), stoi(unitPrice));
			break;

		case 'd':
			cout << "Enter Name of Item:\n";
			getline(cin, itemName);
			obj.deleteItem(itemName);
			break;

		case 's':
			cout << "Enter Name of Item:\n";
			getline(cin, itemName);
			itemEntry *test;
			test = obj.searchItem( itemName );
			if ( test != NULL) {
				cout << "---------------->Searching Result<---------------------" << endl;
				cout << "Item found\n" << "Name of the Item:" << test->itemName << endl << "Company name:" << test->company << endl << "Number of copies available:" << test->copies << endl << "Unit price:" << test->unitPrice << endl;
			}
			else
				cout << "Item not found\n";
			break;

		case 'u':
			cout << "Enter details for update...\n";
			cout << "Enter name: "; getline(cin, itemName);
			cout << "Enter total new entry: "; getline(cin, copies);
			cout << "Enter new price: "; getline(cin, unitPrice);
			obj.updateItem(itemName, stoi(copies), stof(unitPrice));
			break;

		case 'e':
			exit(0);
			break;
		}
	}

	return 0;
}
